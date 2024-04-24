package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.Master;
import org.senla.repository.MasterRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class MasterRepositoryImplTest {

    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );

    static MasterRepository masterRepository = context.getBean("masterRepositoryImpl", MasterRepositoryImpl.class);;

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

        masterRepository.saveAll(List.of(master1, master2, master3));
    }

    @Test
    void remove() {
        masterRepository.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    masterRepository.remove(4L);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void removeNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    masterRepository.remove(-1L);
                }
        );
    }

    @Test
    void getAll() {
        List<Master> masters = masterRepository.getAll();
        assertThat(masters).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, masterRepository.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    masterRepository.get(5L);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void getNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    masterRepository.get(-1L);
                }
        );
    }

    @Test
    void saveAll() {
        assertEquals(2, masterRepository.get(2L).getId());
    }

    static {
        context.close();
    }
}