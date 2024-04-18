package repository;

import model.exception.IdException;
import service.GarageService;

import java.util.List;

public interface CrudRepository<I extends Number, T> {
    void saveAll(List<T> entities);
    void remove(I id) throws IdException;
    List<T> getAll();
    T get(I id) throws IdException;
}