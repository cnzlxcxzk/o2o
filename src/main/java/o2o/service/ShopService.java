package o2o.service;

import o2o.dto.ImageHolder;
import o2o.dto.ShopExcution;
import o2o.entity.Shop;

public interface ShopService {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    ShopExcution addShop(Shop shop, ImageHolder imageHolder);

    /**
     * 根据条件查询店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopExcution getShopList(Shop shopCondition,int pageIndex ,int pageSize);
}
