package com.example.demo.model;

import java.util.List;

public class FloorDataResponse {
    private List<FloorDataList> message;
    private Meta meta;

    public List<FloorDataList> getMessage() {
        return message;
    }

    public void setMessage(List<FloorDataList> message) {
        this.message = message;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class FloorDataList {
        private FloorTitle floor_title;
        private List<Product> product_list;

        public FloorTitle getFloor_title() {
            return floor_title;
        }

        public void setFloor_title(FloorTitle floor_title) {
            this.floor_title = floor_title;
        }

        public List<Product> getProduct_list() {
            return product_list;
        }

        public void setProduct_list(List<Product> product_list) {
            this.product_list = product_list;
        }
    }

    public static class FloorTitle {
        private String name;
        private String image_src;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage_src() {
            return image_src;
        }

        public void setImage_src(String image_src) {
            this.image_src = image_src;
        }
    }

    public static class Product {
        private String image_src;
        private String image_width;
        private String name;
        private String navigator_url;
        private String open_type;

        public String getImage_src() {
            return image_src;
        }

        public void setImage_src(String image_src) {
            this.image_src = image_src;
        }

        public String getImage_width() {
            return image_width;
        }

        public void setImage_width(String image_width) {
            this.image_width = image_width;
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

    public static class Meta {
        private String msg;
        private int status;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
