package repository;

import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для заказов [Singleton]
 * @author Максим Ведеников
 */
public class OrderServiceRepository {
    private static OrderServiceRepository orderServiceRepository;
    /** Список заказов */
    private static Map<Long, Order> listOrder = new HashMap<>();

    /** Получить обьект OrderServiceRepository */
    public static synchronized OrderServiceRepository getOrderServiceRepository() {
        if(orderServiceRepository == null)
            orderServiceRepository = new OrderServiceRepository();
        return orderServiceRepository;
    }

    /** Уадлить заказ */
    public static void removeOrder(Order order) {
        listOrder.remove(order.getId());
    }
    /** Получить все заказы */
    public static List<Order> getListOrder() {
        List<Order> orders = new ArrayList<>();
        for(Map.Entry<Long, Order> entry: listOrder.entrySet()) {
            orders.add(entry.getValue());
        }
        return  orders;
    }
    /** Получить заказ */
    public static Order getOrder(Order order) {
        return listOrder.get(order.getId());
    }
    /** Добавить заказы */
    public static void setListOrder(List<Order> orders) {
        for(Order order: orders) {
            listOrder.put(order.getId(), order);
        }
    }
    /** Добавить заказ */
    public static void setOrder(Order order) {
        listOrder.put(order.getId(), order);
    }
}