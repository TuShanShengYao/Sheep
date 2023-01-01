package com.Sheep.model;

/*
 * 单元格
 *有两种状况
 * 0  无牌
 * 1  有牌
 */
public class Cell {
    //0 1
    private Integer state=0;
    private Brand brand;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
