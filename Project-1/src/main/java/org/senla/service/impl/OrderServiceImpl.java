package org.senla.service.impl;

import org.senla.model.enums.EStatusOrder;
import org.senla.model.Order;
import org.senla.exception.NotFoundException;
import org.senla.repository.OrderRepository;
import org.senla.repository.impl.OrderRepositoryImpl;
import org.senla.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderService orderServiceImpl;
    private static OrderRepository orderRepository;
    private OrderServiceImpl() {};

    /** Получить обьект OrderServiceImpl */
    public static synchronized OrderService getService() {
        if(orderServiceImpl == null) {
            orderServiceImpl = new OrderServiceImpl();
            orderRepository = OrderRepositoryImpl.getRepository();
        }
        return orderServiceImpl;
    }

    /** Добавить заказ */
    public void saveAll(List<Order> order) {
        orderRepository.saveAll(order);
    }
    /** Уадлить заказ */
    public void remove(long id) throws NotFoundException {
        try {
            orderRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить заказ */
    public Order get(long id) throws NotFoundException {
        try {
            return orderRepository.get(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить все заказы */
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    /** Обновить заказ */
    public void updateStatus(long id, EStatusOrder statusOrder) throws NotFoundException {
        try {
            orderRepository.updateStatus(id, statusOrder);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /** Обновить дату */
    public void updateDeadLine(long id, LocalDateTime date) throws NotFoundException {
        try {
            orderRepository.updateDeadLine(id, date);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}