package com.nhom8.WebsiteThoiTrang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ShoppingCartController {

    @RequestMapping("/cart")
    public String home() {
        return "user/cart/index";
    }
}
