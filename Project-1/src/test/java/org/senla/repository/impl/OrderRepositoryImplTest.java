package org.senla.repository.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.senla.exception.NotFoundException;
import org.senla.model.Order;
import org.senla.model.enums.EStatusOrder;
import org.senla.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Максим Ведеников
 * */
class OrderRepositoryImplTest {
    static OrderRepository orderRepository = OrderRepositoryImpl.getRepository();

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
    void getRepository() {
        assertEquals(OrderRepositoryImpl.getRepository(), OrderRepositoryImpl.getRepository());
    }

    @Test
    void remove() {
        orderRepository.remove(1L);
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void removeNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.remove(6L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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
        for(int i=0; i < orders.size(); i++) {
            assertEquals(i+2, orders.get(i).getId());
        }
    }

    @Test
    void get() {
        assertEquals(2, orderRepository.get(2L).getId());
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void getNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.get(5L);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
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

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void updateStatusNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateStatus(6L, EStatusOrder.IN_PROCESS);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс больше, чем может быть) */
    @Test
    void updateDeadLineNotFoundException() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateDeadLine(6L, LocalDateTime.of(2024, 5, 13, 13, 30));
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void updateStatusNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateStatus(-1L, EStatusOrder.IN_PROCESS);
                }
        );
    }

    /** Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть) */
    @Test
    void updateDeadLineNotFoundExceptionNegativeIndex() {
        assertThrows(
                NotFoundException.class,
                () -> {
                    orderRepository.updateDeadLine(-1L, LocalDateTime.of(2024, 5, 13, 13, 30));
                }
        );
    }
}