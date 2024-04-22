package org.senla.service;

import org.senla.exception.NotFoundException;
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
    void remove(long id) throws NotFoundException;
    /** Получить мастера */
    Master get(long id) throws NotFoundException;
    /** Получить мастеров */
    List<Master> getAll();
}