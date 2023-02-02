package zw.co.econet.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.econet.area.service.AreaService;
import zw.co.econet.common.BusinessRuntimeException;
import zw.co.econet.shop.Shop;
import zw.co.econet.shop.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImp implements ShopService {

    @Autowired
    private ShopRepository repository;

    @Autowired
    private AreaService areaService;

    @Override
    public Optional<Shop> save(Shop shop) {
        return Optional.ofNullable(repository.save(shop));
    }


    @Override
    public List<Shop> findShopByArea(String area) {
        var byArea = areaService.findByName(area);

        if (byArea.isPresent())
            return repository.findByArea_Name(area);

        throw new BusinessRuntimeException("Area name " + area + " not Found");
    }

    @Override
    public List<Shop> findAll() {
        return repository.findAll();
    }
}
