package service;

import model.Master;

import java.util.List;

public interface MasterService extends CrudService<Long, Master> {
    void saveAll(List<Master> master);
    void remove(Long id);
    Master get(Long id);
    List<Master> getAll();
}