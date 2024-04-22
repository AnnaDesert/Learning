package org.senla.service.impl;

import org.senla.model.Master;
import org.senla.exception.NotFoundException;
import org.senla.repository.MasterRepository;
import org.senla.repository.impl.MasterRepositoryImpl;
import org.senla.service.MasterService;

import java.util.List;

/**
 * Класс сервис для мастера
 * @author Максим Ведеников
 */
public class MasterServiceImpl implements MasterService {
    private static MasterService masterServiceImpl;
    private static MasterRepository masterRepository;
    private MasterServiceImpl() {};

    /** Получить обьект MasterServiceImpl */
    public static synchronized MasterService getService() {
        if(masterServiceImpl == null) {
            masterServiceImpl = new MasterServiceImpl();
            masterRepository = MasterRepositoryImpl.getRepository();
        }
        return masterServiceImpl;
    }
    
    /** Добавить мастера */
    public void saveAll(List<Master> master) {
        masterRepository.saveAll(master);
    }
    /** Уадлить мастера */
    public void remove(long id) throws NotFoundException {
        try {
            masterRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить мастера */
    public Master get(long id) throws NotFoundException {
        try {
            return masterRepository.get(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить всех мастеров */
    public List<Master> getAll() {
        return masterRepository.getAll();
    }
}