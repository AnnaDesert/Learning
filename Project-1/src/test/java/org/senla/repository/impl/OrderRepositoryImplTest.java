package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.Order;
import org.senla.model.enums.EStatusOrder;
import org.senla.repository.OrderRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Максим Ведеников
 * */
class OrderRepositoryImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static OrderRepository orderRepository = context.getBean("orderRepositoryImpl", OrderRepositoryImpl.class);;

    @BeforeAll
    static void init() {
        Order order1 = new Order();
        order1.setStatus(EStatusOrder.CANCELLED);
        order1.setPrice(10000);
        order1.setDeadLine(LocalDateTime.of(2024, 5, 12, 12, 30));
        Order order2 = new Order();
        order2.setStatus(EStatusOrder.IN_PROCESS);
        order2.setPrice(20000);
        order2.setDeadLine(LocalDateTime.of(2024, 5, 12, 13, 30));
        Order order3 = new Order();
        order3.setDeadLine(LocalDateTime.of(2024, 5, 9, 12, 30));
        order3.setPrice(30000);

        orderRepository.saveAll(List.of(order1, order2, order3));
    }

    @Test
    void remove() {
        orderRepository.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.remove(6L);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void removeNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.remove(-1L);
                }
        );
    }

    @Test
    void getAll() {
        List<Order> orders = orderRepository.getAll();
        assertThat(orders).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, orderRepository.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.get(5L);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void getNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.get(-1L);
                }
        );
    }

    @Test
    void saveAll() {
        assertEquals(2, orderRepository.get(2L).getId());
    }

    @Test
    void updateStatus() {
        orderRepository.updateStatus(2L, EStatusOrder.IN_PROCESS);
        assertEquals(EStatusOrder.IN_PROCESS, orderRepository.get(2L).getStatus());
    }

    @Test
    void updateDeadLine() {
        orderRepository.updateDeadLine(2L, LocalDateTime.of(2024, 5, 13, 13, 30));
        assertEquals(LocalDateTime.of(2024, 5, 13, 13, 30), orderRepository.get(2L).getDeadLine());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void updateStatusNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateStatus(6L, EStatusOrder.IN_PROCESS);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void updateDeadLineNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateDeadLine(6L, LocalDateTime.of(2024, 5, 13, 13, 30));
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void updateStatusNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateStatus(-1L, EStatusOrder.IN_PROCESS);
                }
        );
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void updateDeadLineNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateDeadLine(-1L, LocalDateTime.of(2024, 5, 13, 13, 30));
                }
        );
    }

    static {
        context.close();
    }
}