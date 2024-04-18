package service;

import model.Order;
import model.enums.EStatusOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService extends CrudService<Long, Order> {
    void saveAll(List<Order> order);
    void remove(Long id);
    Order get(Long id);
    List<Order> getAll();
    void updateStatus(Long id, EStatusOrder statusOrder);
    void updateDeadLine(Long id, LocalDateTime date);
}