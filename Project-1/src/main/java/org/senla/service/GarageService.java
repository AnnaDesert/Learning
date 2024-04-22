package org.senla.service;

import org.senla.exception.NotFoundException;
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
    void remove(long id) throws NotFoundException;
    /** Получить гараж */
    Garage get(long id) throws NotFoundException;
    /** Получить гаражи */
    List<Garage> getAll();
}