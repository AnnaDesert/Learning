package org.senla.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.senla.config.SpringConfig;
import org.senla.exception.NotFoundException;
import org.senla.model.Order;
import org.senla.model.enums.EStatusOrder;
import org.senla.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Максим Ведеников
 * */
class OrderServiceImplTest {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SpringConfig.class
    );
    static OrderService orderService = context.getBean("orderServiceImpl", OrderServiceImpl.class);

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

        orderService.saveAll(List.of(order1, order2, order3));
    }

    @Test
    void remove() {
        orderService.remove(1L);
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void removeNotFoundException() {
        try {
            orderService.remove(4L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 4", e.getMessage());
        }
        assertNull(orderService.get(4L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void removeNotFoundExceptionNegativeIndex() {
        try {
            orderService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(orderService.get(-1L));
    }

    @Test
    void getAll() {
        List<Order> orders = orderService.getAll();
        assertThat(orders).isNotEmpty();
    }

    @Test
    void get() {
        assertEquals(2, orderService.get(2L).getId());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void getNotFoundException() {
        try {
            orderService.remove(5L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(orderService.get(5L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void getNotFoundExceptionNegativeIndex() {
        try {
            orderService.remove(-1L);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(orderService.get(-1L));
    }

    @Test
    void saveAll() {
        assertEquals(2, orderService.get(2L).getId());
    }

    @Test
    void updateStatus() {
        orderService.updateStatus(2L, EStatusOrder.IN_PROCESS);
        assertEquals(EStatusOrder.IN_PROCESS, orderService.get(2L).getStatus());
    }

    @Test
    void updateDeadLine() {
        orderService.updateDeadLine(2L, LocalDateTime.of(2024, 5, 13, 13, 30));
        assertEquals(LocalDateTime.of(2024, 5, 13, 13, 30), orderService.get(2L).getDeadLine());
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void updateStatusNotFoundException() {
        try {
            orderService.updateStatus(5L, EStatusOrder.IN_PROCESS);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(orderService.get(5L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс больше, чем может быть)")
    void updateDeadLineNotFoundException() {
        try {
            orderService.updateDeadLine(5L, LocalDateTime.of(2024, 5, 21, 14, 20));
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: 5", e.getMessage());
        }
        assertNull(orderService.get(5L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void updateStatusNotFoundExceptionNegativeIndex() {
        try {
            orderService.updateStatus(-1L, EStatusOrder.IN_PROCESS);
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(orderService.get(-1L));
    }

    @Test
    @DisplayName("Проверяем исключение при недопустимом индексе(индекс меньше, чем может быть)")
    void updateDeadLineNotFoundExceptionNegativeIndex() {
        try {
            orderService.updateDeadLine(-1L, LocalDateTime.of(2024, 5, 21, 14, 20));
        } catch(NotFoundException e) {
            assertEquals("No data was found for this id: -1", e.getMessage());
        }
        assertNull(orderService.get(-1L));
    }

    static {
        context.close();
    }
}