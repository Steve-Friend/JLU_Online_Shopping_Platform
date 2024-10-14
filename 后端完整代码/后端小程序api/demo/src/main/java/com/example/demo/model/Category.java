package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "categories") // 指定数据库中的表 categories
@JsonPropertyOrder({ "cat_deleted", "cat_icon", "cat_id", "cat_level", "cat_name", "cat_pid", "children" }) // 指定输出顺序
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("cat_id") // 指定输出字段名为 cat_id
    private Integer catId;

    @JsonProperty("cat_name") // 指定输出字段名为 cat_name
    private String catName;

    @JsonProperty("cat_pid") // 指定输出字段名为 cat_pid
    private Integer catPid;

    @JsonProperty("cat_level") // 指定输出字段名为 cat_level
    private Integer catLevel;

    @JsonProperty("cat_deleted") // 指定输出字段名为 cat_deleted
    private Boolean catDeleted;

    @JsonProperty("cat_icon") // 指定输出字段名为 cat_icon
    private String catIcon;

    @Transient // 该字段不会映射到数据库
    private List<Category> children = new ArrayList<>(); // 用于存放子类

    // Getters and Setters
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getCatPid() {
        return catPid;
    }

    public void setCatPid(Integer catPid) {
        this.catPid = catPid;
    }

    public Integer getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(Integer catLevel) {
        this.catLevel = catLevel;
    }

    public Boolean getCatDeleted() {
        return catDeleted;
    }

    public void setCatDeleted(Boolean catDeleted) {
        this.catDeleted = catDeleted;
    }

    public String getCatIcon() {
        return catIcon;
    }

    public void setCatIcon(String catIcon) {
        this.catIcon = catIcon;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
