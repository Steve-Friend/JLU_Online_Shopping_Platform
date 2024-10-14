package com.example.demo.controller;

import com.example.demo.model.SwiperData;
import com.example.demo.model.SwiperResponse;
import com.example.demo.model.SwiperResponse.MetaData;
import com.example.demo.repository.SwiperDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwiperDataController {

    @Autowired
    private SwiperDataRepository swiperDataRepository;

    @GetMapping("/api/swiperdata")
    public SwiperResponse getSwiperData() {
        // 获取 swiperdata 数据
        List<SwiperData> swiperDataList = swiperDataRepository.findAll();

        // 创建自定义响应
        SwiperResponse response = new SwiperResponse();
        response.setMessage(swiperDataList);

        // 设置 Meta 信息
        MetaData meta = new MetaData();
        meta.setMsg("获取成功");
        meta.setStatus(200);
        response.setMeta(meta);

        return response;
    }
}
