package com.example.demo.model;

import java.util.List;

public class SwiperResponse {

    private List<SwiperData> message;
    private MetaData meta;

    public List<SwiperData> getMessage() {
        return message;
    }

    public void setMessage(List<SwiperData> message) {
        this.message = message;
    }

    public MetaData getMeta() {
        return meta;
    }

    public void setMeta(MetaData meta) {
        this.meta = meta;
    }

    // 内部类 MetaData 包含消息和状态
    public static class MetaData {
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
