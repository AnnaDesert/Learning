package org.senla.model;

/**
 * Класс-сущность Мастера
 * @author Максим Ведеников
*/
public class Master {
    /** ID мастера */
    private long id;
    /** Имя мастера */
    private String name;
    /** ЗП мастера */
    private long salary;

    /** set-методы */
    public void setName(String name) {this.name = name;}
    public void setId(long id) {this.id = id;}
    public void setSalary(long salary) {this.salary = salary;}

    /** get-методы */
    public String getName() {return name;}
    public long getId() {return id;}
    public long getSalary() {return salary;}

    /** Вывод */
    public String toString() {
        return "ID мастера: "+id+"\nИмя мастера: "+name+"\nЗП мастера: "+salary;
    }
}