package com.example.demo.controller;

import com.example.demo.service.CatItemsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CatItemsController {

    @Resource
    private CatItemsService catItemsService;

    @GetMapping("/api/catitems")
    public Map<String, Object> getCatItems() {
        return catItemsService.getCatItemsApiResponse();
    }
}
