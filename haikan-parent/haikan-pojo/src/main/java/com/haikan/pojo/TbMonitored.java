package com.haikan.pojo;

import java.io.Serializable;

public class TbMonitored implements Serializable{
    private Long id;

    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}