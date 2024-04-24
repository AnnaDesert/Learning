package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.RepairSite;
import org.senla.service.RepairSiteService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class RepairSiteServiceImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static RepairSiteService repairSiteService = context.getBean("repairSiteServiceImpl", RepairSiteServiceImpl.class);

    @BeforeAll
    static void init() {
        RepairSite repairSite1 = new RepairSite();
        RepairSite repairSite2 = new RepairSite();
        RepairSite repairSite3 = new RepairSite();

        repairSiteService.saveAll(List.of(repairSite1, repairSite2, repairSite3));
    }

    @Test
    void remove() {
        repairSiteService.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        try {
            repairSiteService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(repairSiteService.get(4L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
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
        assertThat(repairSites).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, repairSiteService.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        try {
            repairSiteService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(repairSiteService.get(5L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
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

    static {
        context.close();
    }
}