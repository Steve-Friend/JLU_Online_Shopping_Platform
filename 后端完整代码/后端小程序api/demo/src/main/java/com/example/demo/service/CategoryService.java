package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> buildCategoryTree(List<Category> categories) {
        List<Category> topLevelCategories = new ArrayList<>();

        // 创建一个 ID 到类别对象的映射
        for (Category category : categories) {
            if (category.getCatPid() == 0) {
                topLevelCategories.add(category);
            }
        }

        // 递归构建树形结构
        for (Category parent : topLevelCategories) {
            parent.setChildren(getChildren(parent, categories));
        }

        return topLevelCategories;
    }

    private List<Category> getChildren(Category parent, List<Category> allCategories) {
        return allCategories.stream()
                .filter(child -> child.getCatPid().equals(parent.getCatId()))
                .peek(child -> child.setChildren(getChildren(child, allCategories)))
                .collect(Collectors.toList());
    }
}
