package repository;

import model.Garage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для гаражей [Singleton]
 * @author Максим Ведеников
 */
public class GarageServiceRepository {
    private static GarageServiceRepository garageServiceRepository;
    /** Список гаражей */
    private static Map<Long, Garage> listGarage = new HashMap<>();

    /** Получить обьект GarageServiceRepository */
    public static synchronized GarageServiceRepository getGarageServiceRepository() {
        if(garageServiceRepository == null)
            garageServiceRepository = new GarageServiceRepository();
        return garageServiceRepository;
    }

    /** Уадлить гараж */
    public static void removeGarage(Garage garage) {
        listGarage.remove(garage.getId());
    }
    /** Получить все гаражи */
    public static List<Garage> getListGarage() {
        List<Garage> garages = new ArrayList<>();
        for(Map.Entry<Long, Garage> entry: listGarage.entrySet()) {
            garages.add(entry.getValue());
        }
        return  garages;
    }
    /** Получить гараже */
    public static Garage getGarage(Garage garage) {
        return listGarage.get(garage.getId());
    }
    /** Добавить гаражи */
    public static void setListGarage(List<Garage> garages) {
        for(Garage garage: garages) {
            listGarage.put(garage.getId(), garage);
        }
    }
    /** Добавить гараж */
    public static void setGarage(Garage garage) {
        listGarage.put(garage.getId(), garage);
    }
}
