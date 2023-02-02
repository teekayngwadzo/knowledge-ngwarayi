package zw.co.econet.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.econet.assessment.shop.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
