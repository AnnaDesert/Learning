package repository;

import model.Garage;
import model.Order;
import model.RepairSite;
import model.exception.IdException;

import java.util.List;

public interface RepairSiteRepository extends CrudRepository<Long, RepairSite>{
    void remove(Long id) throws IdException;
    List<RepairSite> getAll();
    RepairSite get(Long id)  throws IdException ;
    void saveAll(List<RepairSite> garages);
}