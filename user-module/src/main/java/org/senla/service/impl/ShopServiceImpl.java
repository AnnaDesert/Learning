package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.model.Shop;
import org.senla.repository.ShopRepository;
import org.senla.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void remove(Long id) {
        Optional<Shop> data = shopRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found shop on ID="+id);
        }
        shopRepository.deleteById(id);
    }

    @Override
    public Optional<Shop> getById(Long id) {
        Optional<Shop> data = shopRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found shop on ID="+id);
        }
        return data;
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
        Optional<Shop> data = shopRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found shop on ID="+id);
        }
        return data
                .map(shop -> {
                    updateShop.setId(shop.getId());
                    return shopRepository.save(updateShop);
                });
    }
}