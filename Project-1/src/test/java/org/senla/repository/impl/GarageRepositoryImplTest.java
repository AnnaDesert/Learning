package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.Garage;
import org.senla.repository.GarageRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class GarageRepositoryImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static GarageRepository garageRepository = context.getBean("garageRepositoryImpl", GarageRepositoryImpl.class);
    @BeforeAll
    static void init() {
        Garage garage1 = new Garage();
        garage1.setAddress("Street garage1");
        Garage garage2 = new Garage();
        garage2.setAddress("Street garage2");
        Garage garage3 = new Garage();
        garage3.setAddress("Street garage3");

        garageRepository.saveAll(List.of(garage1, garage2, garage3));
    }
    @Test
    void remove() {
        garageRepository.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void removeNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.remove(-1L);
                }
        );
    }


    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.remove(6L);
                }
        );
    }

    @Test
    void getAll() {
        List<Garage> garages = garageRepository.getAll();
        assertThat(garages).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, garageRepository.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
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

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void getNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    garageRepository.get(-1L);
                }
        );
    }

    static {
        context.close();
    }
}