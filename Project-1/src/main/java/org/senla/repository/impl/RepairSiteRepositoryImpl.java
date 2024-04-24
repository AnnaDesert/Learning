package org.senla.repository.impl;

import org.senla.model.RepairSite;
import org.senla.exception.NotFoundException;
import org.senla.repository.RepairSiteRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для ремонтных площадок [Singleton]
 * @author Максим Ведеников
 */

@Component
public class RepairSiteRepositoryImpl implements RepairSiteRepository {
    /** Счетчик ID */
    private static long ID = 0;
    /** Список ремонтных площадок */
    private static Map<Long, RepairSite> listRepairSite = new HashMap<>();

    private RepairSiteRepositoryImpl() {};

    /** Уадлить ремонтную станцию */
    public void remove(Long id) {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
        }
        listRepairSite.remove(id);
        ID--;
    }
    /** Получить все ремонтные станции */
    public List<RepairSite> getAll() {
        return new ArrayList<>(listRepairSite.values());
    }
    /** Получить ремонтную станцию */
    public RepairSite get(Long id) {
        if(id > ID || id <= 0) {
            throw new NotFoundException("No data was found for this id");
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