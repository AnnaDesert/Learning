package org.senla.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.senla.model.Shop;
import org.senla.model.mapper.ShopListMapper;
import org.senla.swagger.api.ShopApi;
import org.senla.swagger.model.ShopCreationDTO;
import org.senla.swagger.model.ShopDTO;
import org.senla.model.mapper.ShopMapper;
import org.senla.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "shop", description = "Запросы для shop")
@RequiredArgsConstructor
public class ShopApiController implements ShopApi {
    private final ShopService shopService;
    private final ShopMapper shopMapper;
    private final ShopListMapper shopListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addShop(@RequestBody ShopCreationDTO shopDTO) {
        Shop shop = shopMapper.toShop(shopDTO);
        shopService.save(shop);
        return null;
    }
    
    @GetMapping("/shop")
    public ResponseEntity<List<ShopDTO>> allShop() {
        return ResponseEntity.ok(shopListMapper.toDtoList(shopService.getAll()));
    }
    
    @GetMapping("/shop/address/{address}")
    public ResponseEntity<List<ShopDTO>> getShopByAddress(@PathVariable String address) {
        return ResponseEntity.ok(shopListMapper.toDtoList(shopService.getByAddress(address)));
    }
    
    @GetMapping("/shop/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(shopMapper.toDto(shopService.getById(id).get()));
    }
    
    @GetMapping("/shop/name/{name}")
    public ResponseEntity<List<ShopDTO>> getShopByName(@PathVariable String name) {
        return ResponseEntity.ok(shopListMapper.toDtoList(shopService.getByName(name)));
    }
    
    @DeleteMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> removeShopById(@PathVariable @Min(1) Long id) {
        shopService.remove(id);
        return null;
    }

    @PatchMapping("/shop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> updateShop(
            @PathVariable @Min(1) Long id,
            @RequestBody ShopCreationDTO shopDTO
    ) {
        Shop shop = shopMapper.toShop(shopDTO);
        shopService.update(shop, id);
        return null;
    }
}