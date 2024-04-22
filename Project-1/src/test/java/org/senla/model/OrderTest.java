package org.senla.model;

import org.junit.jupiter.api.Test;
import org.senla.model.enums.EStatusOrder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class OrderTest {

    private Order order = new Order();

    @Test
    void getId() {
        assertEquals(0, order.getId());
    }

    @Test
    void getPrice() {
        assertEquals(0, order.getPrice());
    }

    @Test
    void getDeadLine() {
        assertNull(order.getDeadLine());
    }

    @Test
    void getStatus() {
        assertEquals(EStatusOrder.WAITING, order.getStatus());
    }

    @Test
    void setId() {
        order.setId(1);
        assertEquals(1, order.getId());
    }

    @Test
    void setPrice() {
        order.setPrice(10000);
        assertEquals(10000, order.getPrice());
    }

    @Test
    void setDeadLine() {
        order.setDeadLine(LocalDateTime.of(2024, 5, 2, 15, 20));
        assertEquals(LocalDateTime.of(2024, 5, 2, 15, 20), order.getDeadLine());
    }

    @Test
    void setStatus() {
        order.setStatus(EStatusOrder.CANCELLED);
        assertEquals(EStatusOrder.CANCELLED, order.getStatus());
    }

    @Test
    void testToString() {
        assertEquals("ID заказа: 0\nДата выполнения заказа: null\nЦена заказа: 0\nСтатус заказа: WAITING", order.toString());
    }
}