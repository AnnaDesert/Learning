package org.senla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class GarageTest {
    private Garage garage = new Garage();

    @Test
    void getAdress() {
        assertNull(garage.getAdress());
    }

    @Test
    void getId() {
        assertEquals(0, garage.getId());
    }

    @Test
    void setId() {
        garage.setId(3);
        assertEquals(3, garage.getId());
    }

    @Test
    void setAdress() {
        garage.setAdress("Street 2");
        assertEquals("Street 2", garage.getAdress());
    }

    @Test
    void testToString() {
        assertEquals("ID гаража: 0\nАдрес гаража: null", garage.toString());
    }
}