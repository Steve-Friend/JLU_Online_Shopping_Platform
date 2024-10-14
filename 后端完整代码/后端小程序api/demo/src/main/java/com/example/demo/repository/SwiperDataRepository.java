package com.example.demo.repository;

import com.example.demo.model.SwiperData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwiperDataRepository extends JpaRepository<SwiperData, Long> {
}
