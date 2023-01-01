package com.Sheep.utils;

import com.Sheep.model.Brand;
import com.Sheep.model.Cell;
import com.Sheep.model.Layer;
import com.Sheep.model.Map;

import java.awt.*;
import java.util.List;

public class MapUtil {
    public static Map buildMap(Integer floorHeight) {
        Map map = new Map();
        map.setFloorHeight(floorHeight);
        //实现布局
        Layer layer1 = LayerUtil.build(3, 3);
        Layer layer2 = LayerUtil.build(3, 3);
        Layer layer3 = LayerUtil.build(3, 3);
        //构建图层
        layer3.setParent(layer2);
        layer2.setParent(layer1);
        layer1.setParent(null);
        //存入数据
        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);
        return map;
    }

    /*
        函数的作用判定当前牌和某一图层所有牌有矩阵交集
        true就是有交集，那么当前牌就是灰色
        FALSE就是没有交集  显示正常
     */
    public static boolean compare(Brand brand, Layer layer) {
        Cell[][] cells = layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                //如果当前单元格为空， ，不用比较
                Cell cell = cells[row][col];
                //if判断
                if (cell.getState() == 1) {
                    //单元格有牌，可以比较
                    Rectangle temp = cell.getBrand().getBounds();
                    Rectangle rect = brand.getBounds();
                    boolean result = rect.intersects(temp);
                    if (result) {
                        //有交集 说明牌的上层盖住了
                        return result;
                    }
                }
            }
        }
        //判定更上层的牌进行判定
        //加入当时有9层，第六层
        if(layer.getParent()!=null){
           return compare(brand, layer.getParent());
        }
        else{
            //如果parent==null说明已经到头了
            return false;
        }
    }
}