package o2o.dao;

import o2o.entity.Shop;

public interface ShopDao {

    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 根据条件更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
