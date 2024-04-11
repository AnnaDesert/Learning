package service;

import model.RepairSite;
import repository.RepairSiteServiceRepository;

import java.util.List;

/**
 * Класс сервис для ремонтной площадки
 * @author Максим Ведеников
 */
public class RepairSiteService {
    /** Добавить ремонтную площадку */
    public void addRepairSite(RepairSite repairSite) {
        RepairSiteServiceRepository.getRepairSiteServiceRepository().setRepairSite(repairSite);
    }
    /** Уадлить ремонтную площадку */
    public void removeRepairSite(RepairSite repairSite) {
        RepairSiteServiceRepository.getRepairSiteServiceRepository().removeRepairSite(repairSite);
    }
    /** Получить ремонтную площадку */
    public RepairSite getRepairSite(RepairSite repairSite) {
        return RepairSiteServiceRepository.getRepairSiteServiceRepository().getRepairSite(repairSite);
    }
    /** Получить все ремонтные площадку */
    public List<RepairSite> getAllRepairSite() {
        return RepairSiteServiceRepository.getRepairSiteServiceRepository().getListRepairSite();
    }
}
