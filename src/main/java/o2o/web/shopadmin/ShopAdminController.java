package o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "shop")
public class ShopAdminController {

    @RequestMapping(value = "shopoperation")
    private String shopOperation() {
        return "shop/shopoperation";
    }

}
