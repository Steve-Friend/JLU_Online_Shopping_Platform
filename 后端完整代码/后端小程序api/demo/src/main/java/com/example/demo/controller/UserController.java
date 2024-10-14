package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录方法
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        User user = userService.findByUsername(username);

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> meta = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        if (user != null && user.getPassword().equals(password)) {
            meta.put("status", 200);
            meta.put("msg", "登录成功");
            data.put("user_name", user.getUsername());
            data.put("nick_name", user.getNickName());
        } else {
            meta.put("status", 401);
            meta.put("msg", "用户名或密码错误");
        }

        response.put("meta", meta);
        response.put("data", data);

        return response;
    }

    // 注册方法
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> meta = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        // 检查用户名是否已存在
        if (userService.findByUsername(user.getUsername()) != null) {
            meta.put("status", 400);
            meta.put("msg", "用户名已存在");
        } else {
            // 注册用户
            userService.registerUser(user);
            meta.put("status", 200);
            meta.put("msg", "注册成功");
        }

        response.put("meta", meta);
        response.put("data", data);
        return response;
    }
}
