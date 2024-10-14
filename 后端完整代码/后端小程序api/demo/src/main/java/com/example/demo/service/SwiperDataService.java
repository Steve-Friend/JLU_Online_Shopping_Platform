package com.example.demo.service;

import com.example.demo.model.SwiperData;
import com.example.demo.repository.SwiperDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwiperDataService {
    private final SwiperDataRepository swiperDataRepository;

    @Autowired
    public SwiperDataService(SwiperDataRepository swiperDataRepository) {
        this.swiperDataRepository = swiperDataRepository;
    }

    public List<SwiperData> getAllSwiperData() {
        return swiperDataRepository.findAll();
    }
}
