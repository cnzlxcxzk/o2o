package o2o.web.shopadmin;

import o2o.entity.Area;
import o2o.entity.ShopCategory;
import o2o.service.AreaService;
import o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
