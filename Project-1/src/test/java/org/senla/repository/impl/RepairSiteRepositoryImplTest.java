package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.RepairSite;
import org.senla.repository.RepairSiteRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Максим Ведеников
 * */
class RepairSiteRepositoryImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static RepairSiteRepository repairSiteRepository = context.getBean("repairSiteRepositoryImpl", RepairSiteRepositoryImpl.class);;

    @BeforeAll
    static void init() {
        RepairSite repairSite1 = new RepairSite();
        RepairSite repairSite2 = new RepairSite();
        RepairSite repairSite3 = new RepairSite();

        repairSiteRepository.saveAll(List.of(repairSite1, repairSite2, repairSite3));
    }

    @Test
    void remove() {
        repairSiteRepository.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    repairSiteRepository.remove(4L);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
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
        assertThat(repairSites).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, repairSiteRepository.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    repairSiteRepository.get(5L);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
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

    static {
        context.close();
    }
}