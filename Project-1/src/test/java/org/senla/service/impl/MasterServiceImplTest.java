package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.Master;
import org.senla.service.MasterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class MasterServiceImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static MasterService masterService = context.getBean("masterServiceImpl", MasterServiceImpl.class);

    @BeforeAll
    static void init() {
        Master master1 = new Master();
        master1.setName("Name1");
        master1.setSalary(10000);
        Master master2 = new Master();
        master2.setName("Name2");
        master2.setSalary(20000);
        Master master3 = new Master();
        master3.setName("Name3");
        master3.setSalary(30000);

        masterService.saveAll(List.of(master1, master2, master3));
    }

    @Test
    void remove() {
        masterService.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        try {
            masterService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(masterService.get(4L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void removeNotFoundExceptionNegativeIndex() {
        try {
            masterService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(masterService.get(-1L));
    }

    @Test
    void getAll() {
        List<Master> masters = masterService.getAll();
        assertThat(masters).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, masterService.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        try {
            masterService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(masterService.get(5L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void getNotFoundExceptionNegativeIndex() {
        try {
            masterService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(masterService.get(-1L));
    }

    @Test
    void saveAll() {
        assertEquals(2, masterService.get(2L).getId());
    }

    static {
        context.close();
    }
}