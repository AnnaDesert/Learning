package repository;

import model.Master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс репозитрий для мастера [Singleton]
 * @author Максим Ведеников
 */
public class MasterServiceRepository {
    private static MasterServiceRepository masterServiceRepository;
    /** Список мастеров */
    private static Map<Long, Master> listMaster = new HashMap<>();

    /** Получить обьект MasterServiceRepository */
    public static synchronized MasterServiceRepository getMasterServiceRepository() {
        if(masterServiceRepository == null)
            masterServiceRepository = new MasterServiceRepository();
        return masterServiceRepository;
    }

    /** Уадлить мастера */
    public static void removeMaster(Master master) {
        listMaster.remove(master.getId());
    }
    /** Получить всех мастеров */
    public static List<Master> getListMaster() {
        List<Master> masters = new ArrayList<>();
        for(Map.Entry<Long, Master> entry: listMaster.entrySet()) {
            masters.add(entry.getValue());
        }
        return  masters;
    }
    /** Получить мастера */
    public static Master getMaster(Master master) {
        return listMaster.get(master.getId());
    }
    /** Добавить мастеров */
    public static void setListMaster(List<Master> masters) {
        for(Master master: masters) {
            listMaster.put(master.getId(), master);
        }
    }
    /** Добавить мастера */
    public static void setMaster(Master master) {
        listMaster.put(master.getId(), master);
    }
}