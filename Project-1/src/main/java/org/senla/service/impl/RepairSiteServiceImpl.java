package org.senla.service.impl;

import org.senla.model.RepairSite;
import org.senla.exception.NotFoundException;
import org.senla.repository.RepairSiteRepository;
import org.senla.service.RepairSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Класс сервис для ремонтной площадки
 * @author Максим Ведеников
 */

@Component
public class RepairSiteServiceImpl implements RepairSiteService {
    @Autowired
    private RepairSiteRepository repairSiteRepository;
    private RepairSiteServiceImpl() {};

    /** Добавить ремонтную площадку */
    public void saveAll(List<RepairSite> repairSite) {
        repairSiteRepository.saveAll(repairSite);
    }
    /** Уадлить ремонтную площадку */
    public void remove(long id) {
        try {
            repairSiteRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить ремонтную площадку */
    public RepairSite get(long id) {
        try {
            return repairSiteRepository.get(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить все ремонтные площадку */
    public List<RepairSite> getAll() {
        return repairSiteRepository.getAll();
    }
}