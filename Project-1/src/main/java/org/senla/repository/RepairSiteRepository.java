package org.senla.repository;

import org.senla.model.RepairSite;
import org.senla.exception.NotFoundException;

import java.util.List;

/**
 * Интерфейс-репозиторий ремонтной площадки
 * @author Максим Веденикво
 * */
public interface RepairSiteRepository extends CrudRepository<Long, RepairSite> {
    /** Удалить ремонтную площадку */
    void remove(Long id) throws NotFoundException;
    /** Получить ремонтные площадки */
    List<RepairSite> getAll();
    /** Получить ремонтную площадку */
    RepairSite get(Long id)  throws NotFoundException ;
    /** Сохранить ремонтные пложадки */
    void saveAll(List<RepairSite> garages);
}