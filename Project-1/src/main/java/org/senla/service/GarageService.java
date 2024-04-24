package org.senla.service;

import org.senla.model.Garage;

import java.util.List;

/**
 * Интерфейс-сервис гаража
 * @author Максим Веденикво
 * */
public interface GarageService {
    /** Сохранить гаражи */
    void saveAll(List<Garage> garage);
    /** Удалить гараж */
    void remove(long id);
    /** Получить гараж */
    Garage get(long id);
    /** Получить гаражи */
    List<Garage> getAll();
}