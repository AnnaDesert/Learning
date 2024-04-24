package org.senla.repository;

import org.senla.model.RepairSite;

import java.util.List;

/**
 * Интерфейс-репозиторий ремонтной площадки
 * @author Максим Веденикво
 * */
public interface RepairSiteRepository extends CrudRepository<Long, RepairSite> {
    /** Удалить ремонтную площадку */
    void remove(Long id);
    /** Получить ремонтные площадки */
    List<RepairSite> getAll();
    /** Получить ремонтную площадку */
    RepairSite get(Long id);
    /** Сохранить ремонтные пложадки */
    void saveAll(List<RepairSite> garages);
}