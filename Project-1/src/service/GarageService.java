package service;

import model.Garage;

import java.util.List;

public interface GarageService extends CrudService<Long, Garage> {
    void saveAll(List<Garage> garage);
    void remove(Long id);
    Garage get(Long id);
    List<Garage> getAll();
}