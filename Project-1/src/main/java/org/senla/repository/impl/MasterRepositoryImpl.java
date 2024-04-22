package org.senla.repository.impl;

import org.senla.model.Master;
import org.senla.exception.NotFoundException;
import org.senla.repository.MasterRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для мастера [Singleton]
 * @author Максим Ведеников
 */
public class MasterRepositoryImpl implements MasterRepository {
    /** Счетчик ID */
    private static long ID = 0;
    private static MasterRepository masterRepository;
    /** Список мастеров */
    private static Map<Long, Master> listMaster = new HashMap<>();

    private MasterRepositoryImpl() {};

    /** Получить обьект MasterServiceRepository */
    public static synchronized MasterRepository getRepository() {
        if(masterRepository == null) {
            masterRepository = new MasterRepositoryImpl();
        }
        return masterRepository;
    }

    /** Уадлить мастера */
    public void remove(Long id) throws NotFoundException {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        listMaster.remove(id);
        ID--;
    }
    /** Получить всех мастеров */
    public List<Master> getAll() {
        return new ArrayList<>(listMaster.values());
    }
    /** Получить мастера */
    public Master get(Long id) throws NotFoundException {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        return listMaster.get(id);
    }
    /** Добавить мастеров */
    public void saveAll(List<Master> masters) {
        for(Master master: masters) {
            ID++;
            master.setId(ID);
            listMaster.put(ID, master);
        }
    }
}