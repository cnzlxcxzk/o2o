package o2o.web.shopadmin;

import o2o.entity.Area;
import o2o.entity.ShopCategory;
import o2o.service.AreaService;
import o2o.service.ShopCategoryService;
import o2o.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Map<String ,String[]> map = request.getParameterMap();
        map.forEach((name,item) -> model.put(name,item));
        System.out.println(request.getParameter("shop"));
        System.out.println(request.getParameter("shopImg"));
        System.out.println(request.getParameter("verifycode"));
        model.put("success",true);
        return model;
    }
}
