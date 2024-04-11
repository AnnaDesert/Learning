package repository;

import model.RepairSite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для ремонтных площадок [Singleton]
 * @author Максим Ведеников
 */
public class RepairSiteServiceRepository {
    private static RepairSiteServiceRepository repairSiteServiceRepository;
    /** Список ремонтных площадок */
    private static Map<Long, RepairSite> listRepairSite = new HashMap<>();

    /** Получить обьект RepairSiteServiceRepository */
    public static synchronized RepairSiteServiceRepository getRepairSiteServiceRepository() {
        if(repairSiteServiceRepository == null)
            repairSiteServiceRepository = new RepairSiteServiceRepository();
        return repairSiteServiceRepository;
    }

    /** Уадлить ремонтную станцию */
    public static void removeRepairSite(RepairSite repairSite) {
        listRepairSite.remove(repairSite.getId());
    }
    /** Получить все ремонтные станции */
    public static List<RepairSite> getListRepairSite() {
        List<RepairSite> repairSites = new ArrayList<>();
        for(Map.Entry<Long, RepairSite> entry: listRepairSite.entrySet()) {
            repairSites.add(entry.getValue());
        }
        return  repairSites;
    }
    /** Получить ремонтную станцию */
    public static RepairSite getRepairSite(RepairSite repairSite) {
        return listRepairSite.get(repairSite.getId());
    }
    /** Добавить ремонтныу станции */
    public static void setListRepairSite(List<RepairSite> repairSites) {
        for(RepairSite repairSite: repairSites) {
            listRepairSite.put(repairSite.getId(), repairSite);
        }
    }
    /** Добавить ремонтную станцию */
    public static void setRepairSite(RepairSite repairSite) {
        listRepairSite.put(repairSite.getId(), repairSite);
    }
}
