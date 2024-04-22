package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.RepairSite;
import org.senla.service.RepairSiteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class RepairSiteServiceImplTest {
    static RepairSiteService repairSiteService = RepairSiteServiceImpl.getService();

    @BeforeAll
    static void init() {
        RepairSite repairSite1 = new RepairSite();
        RepairSite repairSite2 = new RepairSite();
        RepairSite repairSite3 = new RepairSite();

        repairSiteService.saveAll(List.of(repairSite1, repairSite2, repairSite3));
    }

    @Test
    void getService() {
        assertEquals(RepairSiteServiceImpl.getService(), RepairSiteServiceImpl.getService());
    }

    @Test
    void remove() {
        repairSiteService.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        try {
            repairSiteService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(repairSiteService.get(4L));
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void removeNotFoundExceptionNegativeIndex() {
        try {
            repairSiteService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(repairSiteService.get(-1L));
    }

    @Test
    void getAll() {
        List<RepairSite> repairSites = repairSiteService.getAll();
        for(int i=0; i < repairSites.size(); i++) {
            assertEquals(i+2, repairSites.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, repairSiteService.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        try {
            repairSiteService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(repairSiteService.get(5L));
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void getNotFoundExceptionNegativeIndex() {
        try {
            repairSiteService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(repairSiteService.get(-1L));
    }

    @Test
    void saveAll() {
        assertEquals(2, repairSiteService.get(2L).getId());
    }
}