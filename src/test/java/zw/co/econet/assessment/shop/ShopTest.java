package zw.co.econet.assessment.shop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zw.co.econet.area.Area;
import zw.co.econet.area.service.AreaService;
import zw.co.econet.shop.Shop;
import zw.co.econet.shop.service.ShopService;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopTest {

    @Autowired
    AreaService areaService;

    @Autowired
    ShopService shopService;

    @Test
    public void saveShop() {
        Area area = areaService.findById(1L).get();
        Shop shop = new Shop();
        shop.setName("EconetShop");
        shop.setArea(area);
        var shopToSave = shopService.save(shop);
        assertNotNull(shopToSave);

    }
}
