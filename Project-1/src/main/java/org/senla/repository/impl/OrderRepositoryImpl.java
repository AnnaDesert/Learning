package org.senla.repository.impl;

import org.senla.model.Order;
import org.senla.model.enums.EStatusOrder;
import org.senla.exception.NotFoundException;
import org.senla.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для заказов [Singleton]
 * @author Максим Ведеников
 */
public class OrderRepositoryImpl implements OrderRepository {
    /** Счетчик ID */
    private static long ID = 0;
    private static OrderRepository orderRepository;
    /** Список заказов */
    private static Map<Long, Order> listOrder = new HashMap<>();

    private OrderRepositoryImpl() {};

    /** Получить обьект OrderServiceRepository */
    public static synchronized OrderRepository getRepository() {
        if(orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }

    /** Обновить заказ */
    public void updateStatus(Long id, EStatusOrder statusOrder) throws NotFoundException {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        listOrder.get(id).setStatus(statusOrder);
    }

    /** Уадлить заказ */
    public void remove(Long id) throws NotFoundException {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        listOrder.remove(id);
        ID--;
    }
    /** Получить все заказы */
    public List<Order> getAll() {
        return new ArrayList<>(listOrder.values());
    }
    /** Получить заказ */
    public Order get(Long id) throws NotFoundException {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        return listOrder.get(id);
    }
    /** Добавить заказы */
    public void saveAll(List<Order> orders) {
        for(Order order: orders) {
            ID++;
            order.setId(ID);
            listOrder.put(order.getId(), order);
        }
    }

    public void updateDeadLine(long id, LocalDateTime date) throws NotFoundException {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        listOrder.get(id).setDeadLine(date);
    }
}