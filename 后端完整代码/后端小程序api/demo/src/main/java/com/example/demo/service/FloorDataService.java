package com.example.demo.service;

import com.example.demo.model.FloorData;
import com.example.demo.repository.FloorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorDataService {
    private final FloorDataRepository floorDataRepository;

    @Autowired
    public FloorDataService(FloorDataRepository floorDataRepository) {
        this.floorDataRepository = floorDataRepository;
    }

    // 获取所有楼层数据
    public List<FloorData> getAllFloorData() {
        return floorDataRepository.findAll();
    }

    // 根据ID获取楼层数据
    public FloorData getFloorDataById(int id) {
        return floorDataRepository.findById(id).orElse(null);
    }

    // 保存楼层数据
    public FloorData saveFloorData(FloorData floorData) {
        return floorDataRepository.save(floorData);
    }

    // 根据ID删除楼层数据
    public void deleteFloorData(int id) {
        floorDataRepository.deleteById(id);
    }
}
