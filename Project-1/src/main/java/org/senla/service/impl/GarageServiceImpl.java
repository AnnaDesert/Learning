package org.senla.service.impl;

import org.senla.model.Garage;
import org.senla.exception.NotFoundException;
import org.senla.repository.GarageRepository;
import org.senla.repository.impl.GarageRepositoryImpl;
import org.senla.service.GarageService;

import java.util.List;

/**
 * Класс сервис для гаражей [Singleton]
 * @author Максим Ведеников
 */
public class GarageServiceImpl implements GarageService {
    private static GarageService garageServiceImpl;
    private static GarageRepository garageRepository;
    private GarageServiceImpl() {};

    /** Получить обьект GarageServiceImpl */
    public static synchronized GarageService getService() {
        if(garageServiceImpl == null) {
            garageServiceImpl = new GarageServiceImpl();
            garageRepository = GarageRepositoryImpl.getRepository();
        }
        return garageServiceImpl;
    }

    /** Добавить гараж */
    public void saveAll(List<Garage> garage) {
        garageRepository.saveAll(garage);
    }
    /** Уадлить гараж */
    public void remove(long id) throws NotFoundException {
        try {
            garageRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить гараж */
    public Garage get(long id) throws NotFoundException {
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