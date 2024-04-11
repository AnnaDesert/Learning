package model;

/**
 * Класс-сущность Гаража
 * @author Максим Ведеников
 */
public class Garage {
    /** Адрес гаража */
    private String adress;
    /** ID гаража */
    private long id;

    public String getAdress() {return adress;}
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public void setAdress(String adress) {this.adress = adress;}

    public String toString() {
        return "ID гаража: "+id+"\nАдрес гаража: "+adress;
    }
}