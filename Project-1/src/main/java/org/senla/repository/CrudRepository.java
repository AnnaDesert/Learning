package org.senla.repository;

import java.util.List;

/**
 * Интерфейс-репозиторий
 * @author Максим Веденикво
 * */
public interface CrudRepository<I, T> {
    /** Сохранить */
    void saveAll(List<T> entities);
    /** Удалить */
    void remove(I id);
    /** Получить всё */
    List<T> getAll();
    /** Получить */
    T get(I id);
}