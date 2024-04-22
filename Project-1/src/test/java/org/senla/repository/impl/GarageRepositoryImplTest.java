package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.Garage;
import org.senla.repository.GarageRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class GarageRepositoryImplTest {
    static GarageRepository garageRepository = GarageRepositoryImpl.getRepository();

    @BeforeAll
    static void init() {
        Garage garage1 = new Garage();
        garage1.setAdress("Street garage1");
        Garage garage2 = new Garage();
        garage2.setAdress("Street garage2");
        Garage garage3 = new Garage();
        garage3.setAdress("Street garage3");

        garageRepository.saveAll(List.of(garage1, garage2, garage3));
    }

    @Test
    void getRepository() {
        assertEquals(GarageRepositoryImpl.getRepository(), GarageRepositoryImpl.getRepository());
    }

    @Test
    void remove() {
        garageRepository.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.remove(6L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void removeNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.remove(-1L);
                }
        );
    }

    @Test
    void getAll() {
        List<Garage> garages = garageRepository.getAll();
        for(int i=0; i < garages.size(); i++) {
            assertEquals(i+2, garages.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, garageRepository.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void getNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.get(-1L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.get(5L);
                }
        );
    }

    @Test
    void saveAll() {
        assertEquals(2, garageRepository.get(2L).getId());
    }
}