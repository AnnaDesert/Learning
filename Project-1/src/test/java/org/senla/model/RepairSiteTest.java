package org.senla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Максим Ведеников
 * */
class RepairSiteTest {
    private RepairSite repairSite = new RepairSite();

    @Test
    void getId() {
        assertEquals(0, repairSite.getId());
    }

    @Test
    void setId() {
        repairSite.setId(1);
        assertEquals(1, repairSite.getId());
    }

    @Test
    void testToString() {
        assertEquals("ID ремонтной станци: 0", repairSite.toString());
    }
}