package org.senla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class MasterTest {
    private Master master = new Master();

    @Test
    void setName() {
        master.setName("Максим");
        assertEquals("Максим", master.getName());
    }

    @Test
    void setId() {
        master.setId(1);
        assertEquals(1, master.getId());
    }

    @Test
    void setSalary() {
        master.setSalary(10000);
        assertEquals(10000, master.getSalary());
    }

    @Test
    void getName() {
        assertNull(master.getName());
    }

    @Test
    void getId() {
        assertEquals(0, master.getId());
    }

    @Test
    void getSalary() {
        assertEquals(0, master.getSalary());
    }

    @Test
    void testToString() {
        assertEquals("ID мастера: 0\nИмя мастера: null\nЗП мастера: 0", master.toString());
    }
}