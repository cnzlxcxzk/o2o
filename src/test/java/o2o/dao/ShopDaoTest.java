package o2o.dao;

import o2o.BaseTest;
import o2o.entity.Area;
import o2o.entity.Shop;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;
    @Test
    public void insertShopTest() {
        Shop shop = new Shop();
        shop.setShopName("测试店名");
        Area area = new Area();
        area.setAreaId(7l);
        shop.setArea(area);
        shop.setCreateTime(LocalDateTime.now());
        shop.setAdvice("审核中");
        shop.setEnableStatus(0);
        shop.setLastEditTime(null);
        shop.setLatitude(1l);
        shop.setLongitude(1l);
        shop.setOwnerId(13l);
        shop.setParentShopCategory(null);
        shop.setPhone("18323792273");
        shop.setPriority(1);
        shop.setShopAddr("别院");
        shop.setShopCategoryId(35L);
        shop.setShopDesc("水果店");
        shop.setShopImg("/upload");
        int excptedNum = shopDao.insertShop(shop);
        assert excptedNum ==1;
    }

    @Test
    @Ignore
    public void updateShopTest() {
        Shop shop = new Shop();
        shop.setShopId(62l);
        shop.setCreateTime(LocalDateTime.now());
        shop.setAdvice("不可用");
        shop.setEnableStatus(1);
        int excptedNum = shopDao.updateShop(shop);
        assert excptedNum ==1;
    }

    @Test
    @Ignore
    public void queryShopListTest() {
        Shop shop = new Shop();
        shop.setShopName("测试");
        List<Shop> shops = shopDao.queryShopList(shop,0,3);
        assert shops.size() == 2;
        shops.forEach(System.out::println);
    }
}
