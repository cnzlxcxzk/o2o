package o2o.dto;

import o2o.Enum.ShopStateEnum;
import o2o.entity.Shop;

import java.util.List;

/**
 * 传输过程中Shop对象
 */
public class ShopExcution {

    //状态
    private int state;

    //状态信息
    private String stateInfo;

    //操作的店铺(增删改)
    private Shop shop;

    //查询店铺时的列表
    private List<Shop> shopList;

    public ShopExcution() {
    }

    //操作店铺失败时的构造器
    public ShopExcution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //操作店铺成功时的构造器(增删改)
    public ShopExcution(Shop shop, ShopStateEnum stateEnum) {
        this.shop = shop;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //查询店铺列表成功的构造器
    public ShopExcution(List<Shop> shopList, ShopStateEnum stateEnum) {
        this.shopList = shopList;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
