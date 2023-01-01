package com.Sheep.model;

import com.Sheep.utils.MapUtil;

import java.util.ArrayList;
import java.util.List;

public class Map {
    //层高
    private Integer floorHeight;
    //存方图层
    private List<Layer> list = new ArrayList<>();

    public Integer getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getList() {
        return list;
    }

    public void setList(List<Layer> list) {
        this.list = list;
    }
    /*
    *
    *判断当前map的牌
    * 性能差，牌很多
    * 这个函数什么时候调用
    * 1、游戏开始的时候，
    * 2、牌被点击之后需要调用
    */
    public void compareAll(){
        for (int i = 0; i <list.size(); i++) {
                //i=0是顶层layer
            Layer layer = list.get(i);
            Cell[][] cells = layer.getCells();

            for (int row = 0; row <cells.length ; row++) {
                for (int col = 0; col < cells[row].length; col++) {
                    Cell cell = cells[row][col];
                    if (cell.getState()==1){
                        Brand brand = cell.getBrand();
                        boolean result = MapUtil.compare(brand,layer.getParent());
                        brand.setGray(result);
                    }
                }
            }
        }
    }
}
