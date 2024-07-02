package com.nhom8.WebsiteThoiTrang.controller.user;

import com.nhom8.WebsiteThoiTrang.model.CartItem;
import com.nhom8.WebsiteThoiTrang.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);

        // Calculate total cost
        double totalCost = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        model.addAttribute("totalCost", totalCost);

        return "/cart/cart";
    }
    @PostMapping("/add")
    public String addToCart(@RequestParam long productId, @RequestParam int
            quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }
    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable long productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }
    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }




}
