package org.senla.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Класс-сущность Гаража
 * @author Максим Ведеников
 */

@Component
@Scope("prototype")
public class Garage {
    /** ID гаража */
    private long id;
    /** Адрес гаража */
    private String address;

    /** get-методы */
    public String getAddress() {return address;}
    public long getId() {return id;}

    /** set-методы */
    public void setId(long id) {this.id = id;}
    public void setAddress(String address) {this.address = address;}
    /** Вывод */
    public String toString() {
        return "ID гаража: "+id+"\nАдрес гаража: "+address;
    }
}