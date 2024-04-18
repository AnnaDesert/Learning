package service;

import model.RepairSite;

import java.util.List;

public interface RepairSiteService extends CrudService<Long, RepairSite> {
    void saveAll(List<RepairSite> repairSite);
    void remove(Long id);
    RepairSite get(Long id);
    List<RepairSite> getAll();
}