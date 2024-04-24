package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.Garage;
import org.senla.service.GarageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class GarageServiceImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static GarageService garageService = context.getBean("garageServiceImpl", GarageServiceImpl.class);

    @BeforeAll
    static void init() {
        Garage garage1 = new Garage();
        garage1.setAddress("Street garage1");
        Garage garage2 = new Garage();
        garage2.setAddress("Street garage2");
        Garage garage3 = new Garage();
        garage3.setAddress("Street garage3");

        garageService.saveAll(List.of(garage1, garage2, garage3));
    }

    @Test
    void remove() {
        garageService.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        try {
            garageService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(garageService.get(4L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void removeNotFoundExceptionNegativeIndex() {
        try {
            garageService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(garageService.get(-1L));
    }

    @Test
    void getAll() {
        List<Garage> garages = garageService.getAll();
        assertThat(garages).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, garageService.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        try {
            garageService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(garageService.get(5L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void getNotFoundExceptionNegativeIndex() {
        try {
            garageService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(garageService.get(-1L));
    }

    @Test
    void saveAll() {
        assertEquals(2, garageService.get(2L).getId());
    }

    static {
        context.close();
    }
}