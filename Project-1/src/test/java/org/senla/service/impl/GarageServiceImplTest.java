package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.Garage;
import org.senla.service.GarageService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class GarageServiceImplTest {
    static GarageService garageService = GarageServiceImpl.getService();

    @BeforeAll
    static void init() {
        Garage garage1 = new Garage();
        garage1.setAdress("Street garage1");
        Garage garage2 = new Garage();
        garage2.setAdress("Street garage2");
        Garage garage3 = new Garage();
        garage3.setAdress("Street garage3");

        garageService.saveAll(List.of(garage1, garage2, garage3));
    }

    @Test
    void getService() {
        assertEquals(GarageServiceImpl.getService(), GarageServiceImpl.getService());
    }

    @Test
    void remove() {
        garageService.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        try {
            garageService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(garageService.get(4L));
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
        for(int i=0; i < garages.size(); i++) {
            assertEquals(i+1, garages.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, garageService.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        try {
            garageService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(garageService.get(5L));
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
}