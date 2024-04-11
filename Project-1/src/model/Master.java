package model;

/**
 * Класс-сущность Мастера
 * @author Максим Ведеников
*/
public class Master {
    /** Имя мастера */
    private String name;
    /** ID мастера */
    private long id;
    /** ЗП мастера */
    private int salary;

    /** set-методы */
    public void setName(String name) {this.name = name;}
    public void setId(long id) {this.id = id;}
    public void setSalary(int salary) {this.salary = salary;}

    /** get-методы */
    public String getName() {return name;}
    public long getId() {return id;}
    public int getSalary() {return salary;}

    /** Вывод */
    public String toString() {
        return "ID мастера: "+id+"\nИмя мастера: "+name+"\nЗП мастера: "+salary;
    }
}