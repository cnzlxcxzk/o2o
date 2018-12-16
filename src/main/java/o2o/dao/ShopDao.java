package o2o.dao;

import o2o.entity.PersonInfo;
import o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据条件查询店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
}
