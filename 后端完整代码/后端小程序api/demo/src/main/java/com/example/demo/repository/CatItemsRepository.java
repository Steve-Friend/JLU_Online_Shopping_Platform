package com.example.demo.repository;

import com.example.demo.model.CatItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatItemsRepository extends JpaRepository<CatItems, Integer> {
}
