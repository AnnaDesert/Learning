package org.senla.service.impl;

import org.senla.model.Master;
import org.senla.exception.NotFoundException;
import org.senla.repository.MasterRepository;
import org.senla.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Класс сервис для мастера
 * @author Максим Ведеников
 */

@Component
public class MasterServiceImpl implements MasterService {
    @Autowired
    private MasterRepository masterRepository;
    private MasterServiceImpl() {};
    
    /** Добавить мастера */
    public void saveAll(List<Master> master) {
        masterRepository.saveAll(master);
    }
    /** Уадлить мастера */
    public void remove(long id) {
        try {
            masterRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить мастера */
    public Master get(long id) {
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