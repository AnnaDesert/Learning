package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.Master;
import org.senla.service.MasterService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class MasterServiceImplTest {
    static MasterService masterService = MasterServiceImpl.getService();

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
    void getService() {
        assertEquals(MasterServiceImpl.getService(), MasterServiceImpl.getService());
    }

    @Test
    void remove() {
        masterService.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        try {
            masterService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(masterService.get(4L));
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
        for(int i=0; i < masters.size(); i++) {
            assertEquals(i+2, masters.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, masterService.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        try {
            masterService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(masterService.get(5L));
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
}