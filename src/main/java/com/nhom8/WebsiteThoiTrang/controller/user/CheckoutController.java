package com.nhom8.WebsiteThoiTrang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {
    @RequestMapping("/checkout")
    public String home() {
        return "user/checkout/index";
    }
}
