package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.RepairSite;
import org.senla.repository.RepairSiteRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Максим Ведеников
 * */
class RepairSiteRepositoryImplTest {
    static RepairSiteRepository repairSiteRepository = RepairSiteRepositoryImpl.getRepository();

    @BeforeAll
    static void init() {
        RepairSite repairSite1 = new RepairSite();
        RepairSite repairSite2 = new RepairSite();
        RepairSite repairSite3 = new RepairSite();

        repairSiteRepository.saveAll(List.of(repairSite1, repairSite2, repairSite3));
    }

    @Test
    void getRepository() {
        assertEquals(RepairSiteRepositoryImpl.getRepository(), RepairSiteRepositoryImpl.getRepository());
    }

    @Test
    void remove() {
        repairSiteRepository.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    repairSiteRepository.remove(4L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void removeNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    repairSiteRepository.remove(-1L);
                }
        );
    }

    @Test
    void getAll() {
        List<RepairSite> repairSites = repairSiteRepository.getAll();
        for(int i=0; i < repairSites.size(); i++) {
            assertEquals(i+1, repairSites.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, repairSiteRepository.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    repairSiteRepository.get(5L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void getNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    repairSiteRepository.get(-1L);
                }
        );
    }

    @Test
    void saveAll() {
        assertEquals(2, repairSiteRepository.get(2L).getId());
    }
}