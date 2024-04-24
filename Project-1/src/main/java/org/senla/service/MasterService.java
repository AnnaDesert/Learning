package org.senla.service;

import org.senla.model.Master;

import java.util.List;

/**
 * Интерфейс-сервис мастера
 * @author Максим Веденикво
 * */
public interface MasterService {
    /** Сохранить мастеров */
    void saveAll(List<Master> master);
    /** Удалить мастера */
    void remove(long id);
    /** Получить мастера */
    Master get(long id);
    /** Получить мастеров */
    List<Master> getAll();
}