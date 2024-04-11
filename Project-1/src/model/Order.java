package model;

import enums.EStatusOrder;
import java.util.Calendar;
import java.util.Date;

/**
 * Класс-сущность заказа
 * @author Максим Ведеников
 */
public class Order {
    /** ID заказа */
    private long id;
    /** цена заказа */
    private int price;
    /** время заказа */
    private Date executionTime;
    /** статус заказа */
    private EStatusOrder status = EStatusOrder.ONHOLD;

    /** get-методы */
    public long getId() {return id;}
    public int getPrice() {return price;}
    public Date getExecutionTime() {return executionTime;}
    public EStatusOrder getStatus() {return status;}
    /** set-методы */
    public void setId(long id) {this.id = id;}
    public void setPrice(int price) {this.price = price;}
    public void setExecutionTime(Calendar executionTime) {this.executionTime = executionTime.getTime();}
    public void setStatus(EStatusOrder status) {this.status = status;}
    /** Вывод */
    public String toString() {
        return "ID заказа: "+id+"\nДата выполнения заказа: "+executionTime+"\nЦена заказа: "+price+"\nСтатус заказа: "+status;
    }
}