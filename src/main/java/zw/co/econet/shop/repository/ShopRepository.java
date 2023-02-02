package zw.co.econet.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.econet.shop.Shop;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findByArea_Name(String area);
}
