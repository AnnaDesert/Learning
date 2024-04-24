package org.senla.service.impl;

import org.senla.model.Garage;
import org.senla.exception.NotFoundException;
import org.senla.repository.GarageRepository;
import org.senla.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Класс сервис для гаражей [Singleton]
 * @author Максим Ведеников
 */

@Component
public class GarageServiceImpl implements GarageService {
    @Autowired
    private GarageRepository garageRepository;

    private GarageServiceImpl() {};

    /** Добавить гараж */
    public void saveAll(List<Garage> garage) {
        garageRepository.saveAll(garage);
    }
    /** Уадлить гараж */
    public void remove(long id)  {
        try {
            garageRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить гараж */
    public Garage get(long id) {
        try {
            return garageRepository.get(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить все гаражи */
    public List<Garage> getAll() {
        return garageRepository.getAll();
    }
}