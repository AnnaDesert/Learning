package org.senla.service;

import org.senla.model.RepairSite;

import java.util.List;

/**
 * Интерфейс-сервис ремонтной площадки
 * @author Максим Веденикво
 * */
public interface RepairSiteService {
    /** Сохранить ремонтные площадки */
    void saveAll(List<RepairSite> repairSite);
    /** Удалить ремонтную площадку */
    void remove(long id);
    /** Получить ремонтную площадку */
    RepairSite get(long id);
    /** Получить ремонтные площадки */
    List<RepairSite> getAll();
}