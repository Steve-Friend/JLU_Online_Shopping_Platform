package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "swiperdata") // 指定数据库中的表 swiperdata
@JsonPropertyOrder({ "goods_id", "id", "image_src", "navigator_url", "open_type" }) // 指定输出顺序
public class SwiperData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_src")
    @JsonProperty("image_src") // 确保输出字段名为 image_src
    private String image_src;

    @Column(name = "open_type")
    @JsonProperty("open_type") // 确保输出字段名为 open_type
    private String open_type;

    @Column(name = "goods_id")
    @JsonProperty("goods_id") // 确保输出字段名为 goods_id
    private Integer goods_id;

    @Column(name = "navigator_url")
    @JsonProperty("navigator_url") // 确保输出字段名为 navigator_url
    private String navigator_url;

    // Getters and Setters
    @JsonProperty("goods_id") // 确保输出字段名为 goods_id
    public Integer getGoodsId() {
        return goods_id;
    }

    @JsonProperty("id") // 确保输出字段名为 id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("image_src") // 确保输出字段名为 image_src
    public String getImageSrc() {
        return image_src;
    }

    public void setImageSrc(String imageSrc) {
        this.image_src = imageSrc;
    }

    @JsonProperty("open_type") // 确保输出字段名为 open_type
    public String getOpenType() {
        return open_type;
    }

    public void setOpenType(String opentype) {
        this.open_type = opentype;
    }

    @JsonProperty("goods_id") // 确保输出字段名为 goods_id
    public void setGoodsId(Integer goodsid) {
        this.goods_id = goodsid;
    }

    @JsonProperty("navigator_url") // 确保输出字段名为 navigator_url
    public String getNavigatorUrl() {
        return navigator_url;
    }

    public void setNavigatorUrl(String navigatorUrl) {
        this.navigator_url = navigatorUrl;
    }
}
