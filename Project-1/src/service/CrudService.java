package service;

import java.util.List;

public interface CrudService<I extends Number, T> {
    void saveAll(List<T> entities);
    void remove(I id);
    List<T> getAll();
    T get(I id);
}