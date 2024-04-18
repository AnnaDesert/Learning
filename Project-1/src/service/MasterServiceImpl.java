package service;

import model.Master;
import model.exception.IdException;
import repository.MasterRepositoryImpl;

import java.util.List;

/**
 * Класс сервис для мастера
 * @author Максим Ведеников
 */
public class MasterServiceImpl implements MasterService {
    private static MasterService masterServiceImpl;
    private MasterServiceImpl() {};

    /** Получить обьект MasterServiceImpl */
    public static synchronized MasterService getService() {
        if(masterServiceImpl == null) {
            masterServiceImpl = new MasterServiceImpl();
        }
        return masterServiceImpl;
    }
    
    /** Добавить мастера */
    public void saveAll(List<Master> master) {
        MasterRepositoryImpl.getRepository().saveAll(master);
    }
    /** Уадлить мастера */
    public void remove(Long id) {
        try {
            MasterRepositoryImpl.getRepository().remove(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить мастера */
    public Master get(Long id) {
        try {
            return MasterRepositoryImpl.getRepository().get(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить всех мастеров */
    public List<Master> getAll() {
        return MasterRepositoryImpl.getRepository().getAll();
    }
}