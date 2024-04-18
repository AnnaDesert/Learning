package model;

import model.enums.EStatusOrder;

import java.time.LocalDateTime;
import java.util.Calendar;

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
    private LocalDateTime deadLine;
    /** статус заказа */
    private EStatusOrder status = EStatusOrder.WAITING;

    /** get-методы */
    public long getId() {return id;}
    public int getPrice() {return price;}
    public LocalDateTime getDeadLine() {return deadLine;}
    public EStatusOrder getStatus() {return status;}
    /** set-методы */
    public void setId(long id) {this.id = id;}
    public void setPrice(int price) {this.price = price;}
    public void setDeadLine(LocalDateTime deadLine) {this.deadLine = deadLine;}
    public void setStatus(EStatusOrder status) {this.status = status;}
    /** Вывод */
    public String toString() {
        return "ID заказа: "+id+"\nДата выполнения заказа: "+deadLine+"\nЦена заказа: "+price+"\nСтатус заказа: "+status;
    }
}