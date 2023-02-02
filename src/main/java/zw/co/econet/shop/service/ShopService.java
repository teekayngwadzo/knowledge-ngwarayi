package zw.co.econet.shop.service;

import zw.co.econet.assessment.shop.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    Optional<Shop> save(Shop shop);


    List<Shop> findAll();
}
