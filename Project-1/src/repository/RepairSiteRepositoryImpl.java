package repository;

import model.RepairSite;
import model.exception.IdException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для ремонтных площадок [Singleton]
 * @author Максим Ведеников
 */
public class RepairSiteRepositoryImpl implements RepairSiteRepository {
    /** Счетчик ID */
    private static long ID = 0;
    private static RepairSiteRepository repairSiteRepository;
    /** Список ремонтных площадок */
    private static Map<Long, RepairSite> listRepairSite = new HashMap<>();

    private RepairSiteRepositoryImpl() {};

    /** Получить обьект RepairSiteServiceRepository */
    public static synchronized RepairSiteRepository getRepository() {
        if(repairSiteRepository == null) {
            repairSiteRepository = new RepairSiteRepositoryImpl();
        }
        return repairSiteRepository;
    }

    /** Уадлить ремонтную станцию */
    public void remove(Long id) throws IdException {
        if(id > ID || id <= 0) {
            throw new IdException("No data was found for this id");
        }
        listRepairSite.remove(id);
        ID--;
    }
    /** Получить все ремонтные станции */
    public List<RepairSite> getAll() {
        return new ArrayList<>(listRepairSite.values());
    }
    /** Получить ремонтную станцию */
    public RepairSite get(Long id) throws IdException {
        if(id > ID || id <= 0) {
            throw new IdException("No data was found for this id");
        }
        return listRepairSite.get(id);
    }
    /** Добавить ремонтныу станции */
    public void saveAll(List<RepairSite> repairSites) {
        for(RepairSite repairSite: repairSites) {
            ID++;
            repairSite.setId(ID);
            listRepairSite.put(repairSite.getId(), repairSite);
        }
    }
}