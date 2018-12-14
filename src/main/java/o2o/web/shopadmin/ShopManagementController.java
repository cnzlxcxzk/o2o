package o2o.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import o2o.Enum.ShopStateEnum;
import o2o.dto.ImageHolder;
import o2o.dto.ShopExcution;
import o2o.entity.Area;
import o2o.entity.Shop;
import o2o.entity.ShopCategory;
import o2o.service.AreaService;
import o2o.service.ShopCategoryService;
import o2o.service.ShopService;
import o2o.util.CodeUtil;
import o2o.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value = "shop")
public class ShopManagementController {

    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "getshopinitinfo")
    @ResponseBody
    private Map<String,Object> getShopInitInfo() {
        Map<String,Object> model = new HashMap<>();
        List<Area> areas = new ArrayList<>();
        List<ShopCategory> shopCategories = new ArrayList<>();
        try {
            areas = areaService.getAreaList();
            shopCategories = shopCategoryService.getShopCategoryList(new ShopCategory());
            model.put("arealist",areas);
            model.put("shopcategorylist",shopCategories);
            model.put("success",true);
        }catch (Exception e) {
            model.put("success",false);
            model.put("errmsg",e.getMessage());
        }
        return model;
    }

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> register(HttpServletRequest request) {
        Map<String ,Object> model = new HashMap<>();
        //验证验证码
        if (!CodeUtil.checkVerifyCode(request)) {
            model.put("success",false);
            model.put("errmsg","验证码错误");
            return model;
        }
        //注册店铺
        String shopStr = HttpRequestUtil.getString(request,"shop");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr,Shop.class);
        }catch (Exception e) {
            model.put("success",false);
            model.put("errmsg",e.getMessage());
            return model;
        }

        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest httpServletRequest = (MultipartHttpServletRequest) request;
        shopImg = (CommonsMultipartFile) httpServletRequest.getFile("shopImg");
        if (null == shopImg){
            model.put("success",false);
            model.put("errmsg","上传图片不能为空");
            return model;
        }
        //TODO 从session中获取userId
        shop.setOwnerId(13L);
        try {
            ShopExcution shopExcution = null;
            if(null != shop) {
                ImageHolder imageHolder = new ImageHolder(shopImg.getInputStream(),shopImg.getOriginalFilename());
                shopExcution = shopService.addShop(shop,imageHolder);
                if (shopExcution.getStateInfo().equals(ShopStateEnum.CHECK.getStateInfo())) {
                    //TODO 将新增店铺加入到用户可操作的shoplist中，放入到session里
                    model.put("success",true);
                    return model;
                } else {
                    model.put("success",false);
                    model.put("errmsg",shopExcution.getStateInfo());
                    return model;
                }
            } else {
                model.put("success",false);
                model.put("errmsg","店铺不能为空");
                return model;
            }

        }catch (Exception e) {
            model.put("success",false);
            model.put("errmsg",e.getMessage());
            return model;
        }

    }
}
