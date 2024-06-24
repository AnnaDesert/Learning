package org.senla.service;

import org.senla.model.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    Shop save(Shop shop);
    void remove(Long id);
    Optional<Shop> getById(Long id);
    List<Shop> getByName(String name);
    List<Shop> getByAddress(String address);
    List<Shop> getAll();
    Optional<Shop> update(Shop shop, Long id);
}
