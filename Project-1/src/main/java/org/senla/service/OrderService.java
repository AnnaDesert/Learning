package org.senla.service;

import org.senla.model.Order;
import org.senla.model.enums.EStatusOrder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс-сервис заказа
 * @author Максим Веденикво
 * */
public interface OrderService {
    /** Сохранить заказы */
    void saveAll(List<Order> entities);
    /** Удалить заказ */
    void remove(long id);
    /** Получить заказ */
    Order get(long id);
    /** Получить заказы */
    List<Order> getAll();
    /** Обновить статус заказа */
    void updateStatus(long id, EStatusOrder statusOrder);
    /** Обновить крайний срок заказа */
    void updateDeadLine(long id, LocalDateTime date);
}