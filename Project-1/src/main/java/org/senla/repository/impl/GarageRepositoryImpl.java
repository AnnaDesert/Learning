package org.senla.repository.impl;

import org.senla.model.Garage;
import org.senla.exception.NotFoundException;
import org.senla.repository.GarageRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для гаражей [Singleton]
 * @author Максим Ведеников
 */

@Component
public class GarageRepositoryImpl implements GarageRepository {
    /** Счетчик ID */
    private static long ID = 0;
    /** Список гаражей */
    private static Map<Long, Garage> listGarage = new HashMap<>();

    private GarageRepositoryImpl() {};

    /** Уадлить гараж */
    public void remove(Long id) {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        listGarage.remove(id);
        ID--;
    }
    /** Получить все гаражи */
    public List<Garage> getAll() {
        return new ArrayList<>(listGarage.values());
    }
    /** Получить гараже */
    public Garage get(Long id) {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id: "+id);
        }
        return listGarage.get(id);
    }
    /** Добавить гаражи */
    public void saveAll(List<Garage> garages) {
        for(Garage garage: garages) {
            ID++;
            garage.setId(ID);
            listGarage.put(ID, garage);
        }
    }
}