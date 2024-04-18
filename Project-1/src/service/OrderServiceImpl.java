package service;

import model.enums.EStatusOrder;
import model.Order;
import model.exception.IdException;
import repository.OrderRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderService orderServiceImpl;
    private OrderServiceImpl() {};

    /** Получить обьект OrderServiceImpl */
    public static synchronized OrderService getService() {
        if(orderServiceImpl == null) {
            orderServiceImpl = new OrderServiceImpl();
        }
        return orderServiceImpl;
    }

    /** Добавить заказ */
    public void saveAll(List<Order> order) {
        OrderRepositoryImpl.getRepository().saveAll(order);
    }
    /** Уадлить заказ */
    public void remove(Long id) {
        try {
            OrderRepositoryImpl.getRepository().remove(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить заказ */
    public Order get(Long id) {
        try {
            return OrderRepositoryImpl.getRepository().get(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить все заказы */
    public List<Order> getAll() {
        return OrderRepositoryImpl.getRepository().getAll();
    }

    /** Обновить заказ */
    public void updateStatus(Long id, EStatusOrder statusOrder) {
        OrderRepositoryImpl.getRepository().updateStatus(id, statusOrder);
    }

    /** Обновить дату */
    public void updateDeadLine(Long id, LocalDateTime date) {
        try {
            OrderRepositoryImpl.getRepository().get(id).setDeadLine(date);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
    }
}