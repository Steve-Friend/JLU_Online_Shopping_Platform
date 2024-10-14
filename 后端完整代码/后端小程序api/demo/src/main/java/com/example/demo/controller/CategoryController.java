package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories")
    public Map<String, Object> getCategories() {
        Map<String, Object> response = new HashMap<>();

        // 获取所有类别
        List<Category> categories = categoryService.getCategories();

        // 构建类别树
        List<Category> categoryTree = categoryService.buildCategoryTree(categories);

        // 将结果填充到响应中
        response.put("message", categoryTree);
        response.put("meta", Map.of("msg", "获取成功", "status", 200));

        return response;
    }
}
