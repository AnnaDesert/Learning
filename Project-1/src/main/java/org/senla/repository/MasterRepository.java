package org.senla.repository;

import org.senla.model.Master;
import org.senla.exception.NotFoundException;

import java.util.List;

/**
 * Интерфейс-репозиторий мастера
 * @author Максим Веденикво
 * */
public interface MasterRepository extends CrudRepository<Long, Master> {
    /** Удалить мастера */
    void remove(Long id) throws NotFoundException;
    /** Получить мастеров */
    List<Master> getAll();
    /** Получить мастера */
    Master get(Long id)  throws NotFoundException ;
    /** Сохранить мастеров */
    void saveAll(List<Master> garages);
}