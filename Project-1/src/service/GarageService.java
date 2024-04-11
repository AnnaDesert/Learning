package service;

import model.Garage;
import repository.GarageServiceRepository;

import java.util.List;

/**
 * Класс сервис для гаражей
 * @author Максим Ведеников
 */
public class GarageService {
    /** Добавить гараж */
    public void addGarage(Garage garage) {
        GarageServiceRepository.getGarageServiceRepository().setGarage(garage);
    }
    /** Уадлить гараж */
    public void removeGarage(Garage garage) {
        GarageServiceRepository.getGarageServiceRepository().removeGarage(garage);
    }
    /** Получить гараж */
    public Garage getGarage(Garage garage) {
        return GarageServiceRepository.getGarageServiceRepository().getGarage(garage);
    }
    /** Получить все гаражи */
    public List<Garage> getAllGarage() {
        return GarageServiceRepository.getGarageServiceRepository().getListGarage();
    }
}
