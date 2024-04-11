package service;

import enums.EStatusOrder;
import model.Order;
import repository.OrderServiceRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderService {
    /** Добавить заказ */
    public void addOrder(Order order) {
        OrderServiceRepository.getOrderServiceRepository().setOrder(order);
    }
    /** Уадлить заказ */
    public void removeOrder(Order order) {
        OrderServiceRepository.getOrderServiceRepository().removeOrder(order);
    }
    /** Получить заказ */
    public Order getOrder(Order order) {
        return OrderServiceRepository.getOrderServiceRepository().getOrder(order);
    }
    /** Получить все заказы */
    public List<Order> getAllOrder() {
        return OrderServiceRepository.getOrderServiceRepository().getListOrder();
    }
    /** Отменить заказ */
    public void cancelOrder(Order order) {
        OrderServiceRepository.getOrderServiceRepository().getOrder(order).setStatus(EStatusOrder.CANCELLED);
    }
    /** Приотсановить заказ */
    public void holdOrder(Order order) {
        OrderServiceRepository.getOrderServiceRepository().getOrder(order).setStatus(EStatusOrder.ONHOLD);
    }
    /** Завершить заказ */
    public void completeOrder(Order order) {
        OrderServiceRepository.getOrderServiceRepository().getOrder(order).setStatus(EStatusOrder.COMPLETED);
    }
    /** Установить заказ в работу */
    public void atWorkOrder(Order order) {
        OrderServiceRepository.getOrderServiceRepository().getOrder(order).setStatus(EStatusOrder.ATWORK);
    }
    /** Обновить дату */
    public void updateExecutionTime(Order order, Calendar date) {
        OrderServiceRepository.getOrderServiceRepository().getOrder(order).setExecutionTime(date);
    }
}