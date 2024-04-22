package org.senla.service.impl;

import org.senla.model.RepairSite;
import org.senla.exception.NotFoundException;
import org.senla.repository.RepairSiteRepository;
import org.senla.repository.impl.RepairSiteRepositoryImpl;
import org.senla.service.RepairSiteService;

import java.util.List;

/**
 * Класс сервис для ремонтной площадки
 * @author Максим Ведеников
 */
public class RepairSiteServiceImpl implements RepairSiteService {
    private static RepairSiteService repairSiteServiceImpl;
    private static RepairSiteRepository repairSiteRepository;
    private RepairSiteServiceImpl() {};

    /** Получить обьект RepairSiteServiceImpl */
    public static synchronized RepairSiteService getService() {
        if(repairSiteServiceImpl == null) {
            repairSiteServiceImpl = new RepairSiteServiceImpl();
            repairSiteRepository = RepairSiteRepositoryImpl.getRepository();
        }
        return repairSiteServiceImpl;
    }

    /** Добавить ремонтную площадку */
    public void saveAll(List<RepairSite> repairSite) {
        repairSiteRepository.saveAll(repairSite);
    }
    /** Уадлить ремонтную площадку */
    public void remove(long id) throws NotFoundException {
        try {
            repairSiteRepository.remove(id);
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить ремонтную площадку */
    public RepairSite get(long id) throws NotFoundException {
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