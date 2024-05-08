package org.senla.service.impl;

import org.senla.exception.NotFoundResourceShopException;
import org.senla.model.Shop;
import org.senla.repository.ShopRepository;
import org.senla.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Optional<Shop> save(Shop shop) {
        return Optional.ofNullable(Optional.of(shopRepository.save(shop))
                .orElseThrow(() ->
                        new NotFoundResourceShopException("The shop cannot be saved")));
    }

    @Override
    public void remove(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Optional<Shop> getById(Long id) {
        return Optional.ofNullable(Optional.of(shopRepository.findById(id).get())
                .orElseThrow(() ->
                        new NotFoundResourceShopException("The shop with id " + id + " not found")));
    }

    @Override
    public List<Shop> getByName(String name) {
        return shopRepository.findByName(name);
    }

    @Override
    public List<Shop> getByAddress(String address) {
        return shopRepository.findByAddress(address);
    }

    @Override
    public List<Shop> getAll() {
        return new ArrayList<>(shopRepository.findAll());
    }

    @Override
    public Optional<Shop> update(Shop updateShop, Long id) {
        return Optional.ofNullable(Optional.of(shopRepository.findById(id).get())
                .map(shop -> {
                    shop.setName(updateShop.getName());
                    shop.setAddress(updateShop.getAddress());
                    shop.setIdAdmin(updateShop.getIdAdmin());
                    return shopRepository.save(updateShop);
                })
                .orElseThrow(() ->
                        new NotFoundResourceShopException("The shop cannot be updated")));
    }
}