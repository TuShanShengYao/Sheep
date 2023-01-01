package com.Sheep.test;

import com.Sheep.model.Layer;
import com.Sheep.model.Map;
import com.Sheep.utils.LayerUtil;

import java.util.List;

public class TestBuildMap{
    public static void main(String[] args) {
        //实例化对象
        Map map = new Map();
        map.setFloorHeight(3);
        Layer layer1 = LayerUtil.build(3,3);
        Layer layer2 = LayerUtil.build(6,6);
        Layer layer3 = LayerUtil.build(9,9);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);
        //遍历
        List<Layer> list = map.getList();
        for (int i = 0; i < list.size(); i++) {
            //获取图层
            System.out.println("第"+i+"个图层");
            list.get(i).showCells();
        }
    }
}
