package repository;

import model.Garage;
import model.Order;
import model.enums.EStatusOrder;
import model.exception.IdException;

import java.util.List;

public interface GarageRepository extends CrudRepository<Long, Garage>{
    void remove(Long id) throws IdException;
    List<Garage> getAll();
    Garage get(Long id)  throws IdException ;
    void saveAll(List<Garage> garages);
}