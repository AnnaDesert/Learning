package org.senla.service;

import org.senla.exception.NotFoundException;
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
    void remove(long id) throws NotFoundException;
    /** Получить заказ */
    Order get(long id) throws NotFoundException;
    /** Получить заказы */
    List<Order> getAll();
    /** Обновить статус заказа */
    void updateStatus(long id, EStatusOrder statusOrder) throws NotFoundException;
    /** Обновить крайний срок заказа */
    void updateDeadLine(long id, LocalDateTime date) throws NotFoundException;
}