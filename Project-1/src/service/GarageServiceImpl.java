package service;

import model.Garage;
import model.exception.IdException;
import repository.GarageRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс сервис для гаражей [Singleton]
 * @author Максим Ведеников
 */
public class GarageServiceImpl implements GarageService {
    private static GarageService garageServiceImpl;
    private GarageServiceImpl() {};

    /** Получить обьект GarageServiceImpl */
    public static synchronized GarageService getService() {
        if(garageServiceImpl == null) {
            garageServiceImpl = new GarageServiceImpl();
        }
        return garageServiceImpl;
    }

    /** Добавить гараж */
    public void saveAll(List<Garage> garage) {
        GarageRepositoryImpl.getRepository().saveAll(garage);
    }
    /** Уадлить гараж */
    public void remove(Long id) {
        try {
            GarageRepositoryImpl.getRepository().remove(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить гараж */
    public Garage get(Long id) {
        try {
            return GarageRepositoryImpl.getRepository().get(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить все гаражи */
    public List<Garage> getAll() {
        return GarageRepositoryImpl.getRepository().getAll();
    }
}