package com.example.demo.controller;

import com.example.demo.model.FloorData;
import com.example.demo.model.FloorDataResponse;
import com.example.demo.service.FloorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/floordata")
public class FloorDataController {
    private final FloorDataService floorDataService;

    @Autowired
    public FloorDataController(FloorDataService floorDataService) {
        this.floorDataService = floorDataService;
    }

    @GetMapping
    public FloorDataResponse getAllFloorData() {
        List<FloorData> floorDataList = floorDataService.getAllFloorData();
        FloorDataResponse response = new FloorDataResponse();

        List<FloorDataResponse.FloorDataList> formattedData = new ArrayList<>();
        Map<String, List<FloorData>> groupedData = new HashMap<>();

        // 将数据按楼层标题分组
        for (FloorData floorData : floorDataList) {
            groupedData.putIfAbsent(floorData.getFloorTitleName(), new ArrayList<>());
            groupedData.get(floorData.getFloorTitleName()).add(floorData);
        }

        // 格式化分组数据
        for (Map.Entry<String, List<FloorData>> entry : groupedData.entrySet()) {
            FloorDataResponse.FloorDataList dataList = new FloorDataResponse.FloorDataList();
            FloorDataResponse.FloorTitle floorTitle = new FloorDataResponse.FloorTitle();

            floorTitle.setName(entry.getKey());
            floorTitle.setImage_src(entry.getValue().get(0).getFloorTitleImageSrc()); // 修正此行
            dataList.setFloor_title(floorTitle);
            dataList.setProduct_list(new ArrayList<>());

            for (FloorData fd : entry.getValue()) {
                FloorDataResponse.Product product = new FloorDataResponse.Product();
                product.setImage_src(fd.getProductImageSrc());
                product.setImage_width(fd.getProductImageWidth());
                product.setName(fd.getProductName());
                product.setNavigator_url(fd.getProductNavigatorUrl());
                product.setOpen_type(fd.getProductOpenType());
                dataList.getProduct_list().add(product);
            }
            formattedData.add(dataList);
        }

        response.setMessage(formattedData);
        response.setMeta(new FloorDataResponse.Meta());
        response.getMeta().setMsg("成功");
        response.getMeta().setStatus(200);

        return response;
    }
}
