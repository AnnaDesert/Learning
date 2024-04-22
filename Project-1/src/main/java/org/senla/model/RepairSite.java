package org.senla.model;

/**
 * Класс-сущность места в гараже(ремонтная площадка)
 * @author Максим Ведеников
 */
public class RepairSite {
    /** ID ремонтной площадки */
    private long id;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String toString() {
        return "ID ремонтной станци: "+id;
    }
}