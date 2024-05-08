package org.senla.api;


import org.senla.model.Shop;
import org.senla.model.dto.ShopDTO;
import org.senla.model.dto.ShopMapper;
import org.senla.service.ShopService;
import org.senla.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

import static java.util.stream.Collectors.toList;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T16:09:04.794912+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
@RestController
@RequestMapping("${openapi.openAPI30.base-path:}")
public class ShopApiController implements ShopApi {

    private final NativeWebRequest request;
    private final ShopService shopService;
    private final ShopMapper shopMapper;

    @Autowired
    public ShopApiController(NativeWebRequest request, ShopServiceImpl shopService, ShopMapper shopMapper) {
        this.request = request;
        this.shopService = shopService;
        this.shopMapper = shopMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShop(@RequestBody ShopDTO shopDTO) {
        Shop shop = shopMapper.toShop(shopDTO);
        shopService.save(shop);
    }

    @Override
    @GetMapping("/shop")
    public List<ShopDTO> allShop() {
        return shopService.getAll()
                .stream()
                .map(shopMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/shop/address/{address}")
    public List<ShopDTO> getShopByAddress(@PathVariable String address) {
        return shopService.getByAddress(address)
                .stream()
                .map(shopMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/shop/{id}")
    public Optional<ShopDTO> getShopById(@PathVariable Long id) {
        return shopService.getById(id).map(shopMapper::toDto);
    }

    @Override
    @GetMapping("/shop/name/{name}")
    public List<ShopDTO> getShopByName(@PathVariable String name) {
        return shopService.getByName(name)
                .stream()
                .map(shopMapper::toDto)
                .collect(toList());
    }

    @Override
    @DeleteMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeShopById(@PathVariable Long id) {
        shopService.remove(id);
    }

    @Override
    @PatchMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShop(@RequestBody ShopDTO shopDTO, @PathVariable Long id) {
        Shop shop = shopMapper.toShop(shopDTO);
        shopService.update(shop, id);
    }
}