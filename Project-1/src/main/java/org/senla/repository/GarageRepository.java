package org.senla.repository;

import org.senla.model.Garage;

import java.util.List;

/**
 * Интерфейс-репозиторий гаража
 * @author Максим Веденикво
 * */
public interface GarageRepository extends CrudRepository<Long, Garage> {
    /** Удалить гаражи */
    void remove(Long id);
    /** Получить гаражи */
    List<Garage> getAll();
    /** Получить гараж */
    Garage get(Long id);
    /** Сохранить гаражи */
    void saveAll(List<Garage> garages);
}