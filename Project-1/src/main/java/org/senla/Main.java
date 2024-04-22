package org.senla;

import org.senla.model.Order;
import org.senla.service.impl.OrderServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> repair1 = new ArrayList<>();
        List<Order> repair2 = new ArrayList<>();
        Order ord1 = new Order();
        ord1.setDeadLine(LocalDateTime.of(2024, 4, 20, 15, 30));
        repair1.add(new Order());
        repair1.add(ord1);
        repair2.add(new Order());


        OrderServiceImpl.getService().saveAll(repair1);
        OrderServiceImpl.getService().saveAll(repair2);

        List<Order> repairs = new ArrayList<>();
        repairs = OrderServiceImpl.getService().getAll();
        for(Order repair: repairs) {
            System.out.println(repair+"\n");
        }
        OrderServiceImpl.getService().remove(repair2.getFirst().getId());
        repairs = OrderServiceImpl.getService().getAll();
        for(Order repair: repairs) {
            System.out.println(repair+"\n");
        }

        List<Order> repair3 = new ArrayList<>();
        repair3.add(new Order());
        OrderServiceImpl.getService().saveAll(repair3);

        repairs = OrderServiceImpl.getService().getAll();
        for(Order repair: repairs) {
            System.out.println(repair+"\n");
        }

        System.out.println(OrderServiceImpl.getService().get(9)+"\n");
     }
}