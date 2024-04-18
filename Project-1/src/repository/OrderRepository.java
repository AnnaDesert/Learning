package repository;

import model.Garage;
import model.Order;
import model.enums.EStatusOrder;
import model.exception.IdException;

import java.util.List;

public interface OrderRepository extends CrudRepository<Long, Order>{
    void remove(Long id) throws IdException;
    List<Order> getAll();
    Order get(Long id)  throws IdException ;
    void saveAll(List<Order> garages);
    void updateStatus(Long id, EStatusOrder statusOrder);
}