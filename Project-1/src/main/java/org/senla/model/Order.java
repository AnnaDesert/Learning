package org.senla.model;

import org.senla.model.enums.EStatusOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Класс-сущность заказа
 * @author Максим Ведеников
 */

@Component
@Scope("prototype")
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