package o2o.service;

import o2o.dto.ImageHolder;
import o2o.dto.ShopExcution;
import o2o.entity.Shop;

public interface ShopService {
    /**
     *
     * @param shop
     * @return
     */
    ShopExcution addShop(Shop shop, ImageHolder imageHolder);
}
