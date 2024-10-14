package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "catitems") // 指定数据库中的表 catitems
@JsonPropertyOrder({ "id", "image_src", "name", "navigator_url", "open_type" }) // 指定输出顺序
public class CatItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id") // 指定输出字段名为 id
    private Integer id;

    @JsonProperty("image_src") // 指定输出字段名为 image_src
    private String image_src;

    @JsonProperty("name") // 指定输出字段名为 name
    private String name;

    @JsonProperty("navigator_url") // 指定输出字段名为 navigator_url
    private String navigator_url;

    @JsonProperty("open_type") // 指定输出字段名为 open_type
    private String open_type;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNavigator_url() {
        return navigator_url;
    }

    public void setNavigator_url(String navigator_url) {
        this.navigator_url = navigator_url;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }
}
