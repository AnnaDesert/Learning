package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.Master;
import org.senla.repository.MasterRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class MasterRepositoryImplTest {
    static MasterRepository masterRepository = MasterRepositoryImpl.getRepository();

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
    void getRepository() {
        assertEquals(MasterRepositoryImpl.getRepository(), MasterRepositoryImpl.getRepository());
    }

    @Test
    void remove() {
        masterRepository.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    masterRepository.remove(4L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
        for(int i=0; i < masters.size(); i++) {
            assertEquals(i+1, masters.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, masterRepository.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    masterRepository.get(5L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
}