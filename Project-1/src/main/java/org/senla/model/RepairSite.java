package org.senla.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Класс-сущность места в гараже(ремонтная площадка)
 * @author Максим Ведеников
 */

@Component
@Scope("prototype")
public class RepairSite {
    /** ID ремонтной площадки */
    private long id;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String toString() {
        return "ID ремонтной станци: "+id;
    }
}