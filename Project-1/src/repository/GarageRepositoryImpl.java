package repository;

import model.Garage;
import model.exception.IdException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для гаражей [Singleton]
 * @author Максим Ведеников
 */
public class GarageRepositoryImpl implements GarageRepository {
    /** Счетчик ID */
    private static long ID = 0;
    private static GarageRepository garageRepositoryImpl;
    /** Список гаражей */
    private static Map<Long, Garage> listGarage = new HashMap<>();

    private GarageRepositoryImpl() {};

    /** Получить обьект GarageRepositoryImpl */
    public static synchronized GarageRepository getRepository() {
        if(garageRepositoryImpl == null) {
            garageRepositoryImpl = new GarageRepositoryImpl();
        }
        return garageRepositoryImpl;
    }


    /** Уадлить гараж */
    public void remove(Long id) throws IdException {
        if(id > ID || id <= 0) {
            throw new IdException("No data was found for this id");
        }
        listGarage.remove(id);
        ID--;
    }
    /** Получить все гаражи */
    public List<Garage> getAll() {
        return new ArrayList<>(listGarage.values());
    }
    /** Получить гараже */
    public Garage get(Long id) throws IdException {
        if(id > ID || id <= 0) {
            throw new IdException("No data was found for this id");
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