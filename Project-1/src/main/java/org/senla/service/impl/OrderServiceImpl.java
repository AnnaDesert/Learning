package org.senla.service.impl;

import org.senla.model.enums.EStatusOrder;
import org.senla.model.Order;
import org.senla.exception.NotFoundException;
import org.senla.repository.OrderRepository;
import org.senla.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private OrderServiceImpl() {};

    /** Добавить заказ */
    public void saveAll(List<Order> order) {
        orderRepository.saveAll(order);
    }
    /** Уадлить заказ */
    public void remove(long id) {
        try {
            orderRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить заказ */
    public Order get(long id) {
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
    public void updateStatus(long id, EStatusOrder statusOrder) {
        try {
            orderRepository.updateStatus(id, statusOrder);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /** Обновить дату */
    public void updateDeadLine(long id, LocalDateTime date) {
        try {
            orderRepository.updateDeadLine(id, date);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}