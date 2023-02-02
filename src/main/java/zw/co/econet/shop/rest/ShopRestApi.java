package zw.co.econet.shop.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zw.co.econet.area.repository.AreaRepository;
import zw.co.econet.common.ApiResponse;
import zw.co.econet.common.BusinessRuntimeException;
import zw.co.econet.shop.Shop;
import zw.co.econet.shop.service.ShopService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ShopRestApi {

    @Autowired
    private ShopService shopService;

    @Autowired
    private AreaRepository areaRepository;


    @PostMapping("/{areaId}/save")
    public ApiResponse<Shop> saveShop(@PathVariable(value = "areaId") Long areaId, @RequestBody Shop shop) {
        var area = areaRepository.findById(areaId).orElseThrow(() -> new BusinessRuntimeException("Area Not Found"));
        shop.setArea(area);
        Optional<Shop> optionalShop = shopService.save(shop);
        shop = optionalShop.orElseThrow(() -> new BusinessRuntimeException("Internal Error Occurred While Creating Invoice"));
        return new ApiResponse<>(HttpStatus.OK.value(), "Transaction Processed Successfully", shop);

    }

    @GetMapping
    public ApiResponse<List<Shop>> findAllShops() {

        List<Shop> shops = shopService.findAll();
        return new ApiResponse<>(HttpStatus.OK.value(), "Transaction Processed Successfully", shops);

    }


}
