package org.senla.model;

/**
 * Класс-сущность Гаража
 * @author Максим Ведеников
 */
public class Garage {
    /** ID гаража */
    private long id;
    /** Адрес гаража */
    private String adress;

    /** get-методы */
    public String getAdress() {return adress;}
    public long getId() {return id;}

    /** set-методы */
    public void setId(long id) {this.id = id;}
    public void setAdress(String adress) {this.adress = adress;}
    /** Вывод */
    public String toString() {
        return "ID гаража: "+id+"\nАдрес гаража: "+adress;
    }
}