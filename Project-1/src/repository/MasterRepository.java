package repository;

import model.Garage;
import model.Master;
import model.Order;
import model.exception.IdException;

import java.util.List;

public interface MasterRepository extends CrudRepository<Long, Master>{
    void remove(Long id) throws IdException;
    List<Master> getAll();
    Master get(Long id)  throws IdException ;
    void saveAll(List<Master> garages);
}