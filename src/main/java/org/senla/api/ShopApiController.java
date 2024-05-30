package org.senla.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.senla.model.Shop;
import org.senla.model.dto.ShopCreationDTO;
import org.senla.model.dto.ShopDTO;
import org.senla.model.mapper.ShopMapper;
import org.senla.service.ShopService;
import org.senla.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "shop", description = "Запросы для shop")
public class ShopApiController {
    private final ShopService shopService;
    private final ShopMapper shopMapper;

    @Autowired
    public ShopApiController(ShopServiceImpl shopService, ShopMapper shopMapper) {
        this.shopService = shopService;
        this.shopMapper = shopMapper;
    }

    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShop(@RequestBody ShopCreationDTO shopDTO) {
        Shop shop = shopMapper.toShop(shopDTO);
        shopService.save(shop);
    }

    
    @GetMapping("/shop")
    public List<ShopDTO> allShop() {
        return shopService.getAll()
                .stream()
                .map(shopMapper::toDto)
                .collect(toList());
    }

    
    @GetMapping("/shop/address/{address}")
    public List<ShopDTO> getShopByAddress(@PathVariable String address) {
        return shopService.getByAddress(address)
                .stream()
                .map(shopMapper::toDto)
                .collect(toList());
    }

    
    @GetMapping("/shop/{id}")
    public Optional<ShopDTO> getShopById(@PathVariable @Min(1) Long id) {
        return shopService.getById(id).map(shopMapper::toDto);
    }

    
    @GetMapping("/shop/name/{name}")
    public List<ShopDTO> getShopByName(@PathVariable String name) {
        return shopService.getByName(name)
                .stream()
                .map(shopMapper::toDto)
                .collect(toList());
    }

    
    @DeleteMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeShopById(@PathVariable @Min(1) Long id) {
        shopService.remove(id);
    }

    
    @PatchMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShop(
            @RequestBody ShopCreationDTO shopDTO,
            @PathVariable @Min(1) Long id) {
        Shop shop = shopMapper.toShop(shopDTO);
        shopService.update(shop, id);
    }
}