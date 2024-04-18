package service;

import model.RepairSite;
import model.exception.IdException;
import repository.RepairSiteRepositoryImpl;

import java.util.List;

/**
 * Класс сервис для ремонтной площадки
 * @author Максим Ведеников
 */
public class RepairSiteServiceImpl implements RepairSiteService {
    private static RepairSiteService repairSiteServiceImpl;
    private RepairSiteServiceImpl() {};

    /** Получить обьект RepairSiteServiceImpl */
    public static synchronized RepairSiteService getService() {
        if(repairSiteServiceImpl == null) {
            repairSiteServiceImpl = new RepairSiteServiceImpl();
        }
        return repairSiteServiceImpl;
    }

    /** Добавить ремонтную площадку */
    public void saveAll(List<RepairSite> repairSite) {
        RepairSiteRepositoryImpl.getRepository().saveAll(repairSite);
    }
    /** Уадлить ремонтную площадку */
    public void remove(Long id) {
        try {
            RepairSiteRepositoryImpl.getRepository().remove(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Получить ремонтную площадку */
    public RepairSite get(Long id) {
        try {
            return RepairSiteRepositoryImpl.getRepository().get(id);
        }catch(IdException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /** Получить все ремонтные площадку */
    public List<RepairSite> getAll() {
        return RepairSiteRepositoryImpl.getRepository().getAll();
    }
}