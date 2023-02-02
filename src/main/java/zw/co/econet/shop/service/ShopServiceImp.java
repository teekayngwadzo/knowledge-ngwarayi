package zw.co.econet.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.econet.assessment.shop.Shop;
import zw.co.econet.assessment.shop.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImp implements ShopService {

    @Autowired
    private ShopRepository repository;

    @Override
    public Optional<Shop> save(Shop shop) {
        return Optional.ofNullable(repository.save(shop));
    }


    @Override
    public List<Shop> findAll() {
        return repository.findAll();
    }
}
