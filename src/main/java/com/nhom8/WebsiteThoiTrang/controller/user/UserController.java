package com.nhom8.WebsiteThoiTrang.controller.user;

import com.nhom8.WebsiteThoiTrang.model.User;
import com.nhom8.WebsiteThoiTrang.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller // Đánh dấu lớp này là một Controller trong Spring MVC.
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String register(@NotNull Model model) {
        model.addAttribute("user", new User()); // Thêm một đối tượng User mới vào model
        return "account/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, // Validate đối tượng User
                           @NotNull BindingResult bindingResult, // Kết quả của quá trình validate
                           Model model) {
        if (userService.emailExists(user.getEmail())) { // Kiểm tra nếu email đã tồn tại
            bindingResult.rejectValue("email", "error.user", "Email đã tồn tại");
        }
        if (userService.phoneExists(user.getPhone())) { // Kiểm tra nếu phone đã tồn tại
            bindingResult.rejectValue("phone", "error.user", "Phone đã tồn tại");
        }
        if (userService.userExists(user.getUsername())) {
            bindingResult.rejectValue("username", "error.user", "Username đã tồn tại ");
        }

        if (bindingResult.hasErrors()) { // Kiểm tra nếu có lỗi validate
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            return "account/register"; // Trả về lại view "register" nếu có lỗi
        }

        userService.save(user); // Lưu người dùng vào cơ sở dữ liệu
        userService.setDefaultRole(user.getUsername()); // Gán vai trò mặc định cho người dùng
        return "redirect:/login"; // Chuyển hướng người dùng tới trang "login"
    }
}