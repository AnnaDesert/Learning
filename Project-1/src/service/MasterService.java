package service;

import model.Master;
import repository.MasterServiceRepository;

import java.util.List;

/**
 * Класс сервис для мастера
 * @author Максим Ведеников
 */
public class MasterService {
    /** Добавить мастера */
    public void addMaster(Master master) {
        MasterServiceRepository.getMasterServiceRepository().setMaster(master);
    }
    /** Уадлить мастера */
    public void removeMaster(Master master) {
        MasterServiceRepository.getMasterServiceRepository().removeMaster(master);
    }
    /** Получить мастера */
    public Master getMaster(Master master) {
        return MasterServiceRepository.getMasterServiceRepository().getMaster(master);
    }
    /** Получить всех мастеров */
    public List<Master> getAllMaster() {
        return MasterServiceRepository.getMasterServiceRepository().getListMaster();
    }
}