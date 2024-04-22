package org.senla.service;

import org.senla.exception.NotFoundException;
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
    void remove(long id) throws NotFoundException;
    /** Получить ремонтную площадку */
    RepairSite get(long id) throws NotFoundException;
    /** Получить ремонтные площадки */
    List<RepairSite> getAll();
}