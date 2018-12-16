package o2o.service.serviceimp;

import o2o.Enum.ShopStateEnum;
import o2o.dao.ShopDao;
import o2o.dto.ImageHolder;
import o2o.dto.ShopExcution;
import o2o.entity.Shop;
import o2o.service.ShopService;
import o2o.util.FileUtil;
import o2o.util.ImageUtil;
import o2o.util.PageCalculateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImp implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExcution addShop(Shop shop, ImageHolder imageHolder) {

        if (null == shop)
            return new ShopExcution(ShopStateEnum.NULL_SHOP);
        try {
            //初始化店铺
            shop.setCreateTime(LocalDateTime.now());
            shop.setLastEditTime(LocalDateTime.now());
            shop.setEnableStatus(0);//审核中

            //添加店铺信息
            int effctedNum = shopDao.insertShop(shop);
            if(effctedNum <= 0)
                throw new RuntimeException("创建店铺失败");
            else {
                if(null != imageHolder) {
                    addShopImg(shop,imageHolder);
                    effctedNum = shopDao.updateShop(shop);
                    if (effctedNum <= 0) {
                        throw new RuntimeException("创建图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("addShop error: " + e.getMessage());
        }
        return new ShopExcution(shop, ShopStateEnum.CHECK);
    }

    @Override
    public ShopExcution getShopList(Shop shopCondition, int pageIndex, int pageSize) {

        int rowIndex = PageCalculateUtil.getRowIndex(pageIndex,pageSize);
        ShopExcution shopExcution = new ShopExcution();
        try {
            List<Shop> shops =shopDao.queryShopList(shopCondition,rowIndex,pageSize);
            if (null != shops) {
                shopExcution.setShopList(shops);
                shopExcution.setStateInfo(ShopStateEnum.SUCCESS.getStateInfo());
            } else {
                shopExcution.setStateInfo(ShopStateEnum.NULL_SHOP.getStateInfo());
            }
        } catch (Exception e) {
            shopExcution.setStateInfo(ShopStateEnum.INNER_ERROR.getStateInfo());
    }
        return shopExcution;
    }

    private void addShopImg(Shop shop, ImageHolder imageHolder) {

        String path = FileUtil.getShopImgPath(shop);
        ImageUtil.generateThumbnail(imageHolder,FileUtil.getBasePath() + path);
        shop.setShopImg(path);
    }
}
