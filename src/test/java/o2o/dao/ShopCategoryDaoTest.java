package o2o.dao;

import o2o.BaseTest;
import o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategoryTest() {
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
        assert shopCategories.size() == 2;
        shopCategories.forEach(System.out::println);
    }
}
