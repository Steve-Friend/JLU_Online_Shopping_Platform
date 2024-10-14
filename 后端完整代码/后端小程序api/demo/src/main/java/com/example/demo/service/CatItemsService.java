package com.example.demo.service;

import com.example.demo.model.CatItems;
import com.example.demo.repository.CatItemsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatItemsService {

    @Resource
    private CatItemsRepository catItemsRepository;

    public List<CatItems> getCatItems() {
        return catItemsRepository.findAll();
    }

    public Map<String, Object> getCatItemsApiResponse() {
        List<CatItems> catItemsList = getCatItems();

        Map<String, Object> response = new HashMap<>();
        response.put("message", catItemsList);
        response.put("meta", Map.of("msg", "获取成功", "status", 200));

        return response;
    }
}
