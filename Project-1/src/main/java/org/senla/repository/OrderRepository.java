package org.senla.repository;

import org.senla.model.Order;
import org.senla.model.enums.EStatusOrder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Интерфейс-репозиторий заказа
 * @author Максим Веденикво
 * */
public interface OrderRepository extends CrudRepository<Long, Order> {
    /** Удалить заказ */
    void remove(Long id);
    /** Получить заказы */
    List<Order> getAll();
    /** Получить заказ */
    Order get(Long id);
    /** Сохранить заказы */
    void saveAll(List<Order> garages);
    /** Обновить статус заказа */
    void updateStatus(Long id, EStatusOrder statusOrder);
    /** Обновить времня на выполнение(крайний срок) заказа */
    void updateDeadLine(long id, LocalDateTime date);
}