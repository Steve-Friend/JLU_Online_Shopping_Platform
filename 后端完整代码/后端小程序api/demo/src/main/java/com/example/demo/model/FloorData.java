package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "floordata") // 指定数据库中的表 floordata
public class FloorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "floor_title_name") // 指定数据库中的列名
    private String floorTitleName;

    @Column(name = "floor_title_image_src") // 指定数据库中的列名
    private String floorTitleImageSrc;

    @Column(name = "product_name") // 指定数据库中的列名
    private String productName;

    @Column(name = "product_image_src") // 指定数据库中的列名
    private String productImageSrc;

    @Column(name = "product_image_width") // 指定数据库中的列名
    private String productImageWidth;

    @Column(name = "product_open_type") // 指定数据库中的列名
    private String productOpenType;

    @Column(name = "product_navigator_url") // 指定数据库中的列名
    private String productNavigatorUrl;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFloorTitleName() {
        return floorTitleName;
    }

    public void setFloorTitleName(String floorTitleName) {
        this.floorTitleName = floorTitleName;
    }

    public String getFloorTitleImageSrc() {
        return floorTitleImageSrc;
    }

    public void setFloorTitleImageSrc(String floorTitleImageSrc) {
        this.floorTitleImageSrc = floorTitleImageSrc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageSrc() {
        return productImageSrc;
    }

    public void setProductImageSrc(String productImageSrc) {
        this.productImageSrc = productImageSrc;
    }

    public String getProductImageWidth() {
        return productImageWidth;
    }

    public void setProductImageWidth(String productImageWidth) {
        this.productImageWidth = productImageWidth;
    }

    public String getProductOpenType() {
        return productOpenType;
    }

    public void setProductOpenType(String productOpenType) {
        this.productOpenType = productOpenType;
    }

    public String getProductNavigatorUrl() {
        return productNavigatorUrl;
    }

    public void setProductNavigatorUrl(String productNavigatorUrl) {
        this.productNavigatorUrl = productNavigatorUrl;
    }
}
