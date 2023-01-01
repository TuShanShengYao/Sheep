package com.Sheep.utils;

import com.Sheep.model.Brand;
import com.Sheep.model.Cell;
import com.Sheep.model.Layer;

public class LayerUtil {
    public static Layer build(Integer rowNum,Integer colNum){
            //创建图层
        Layer layer = null;
        try {
            layer = new Layer(rowNum,colNum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        System.out.println(getBrandName());
            //创建一个brand数组
            Brand[] brands =BrandUtil.buildBrands(layer.getCapacity());
            //返回二维数组
            Cell[][] cells = layer.getCells();
            //定义标记位
            int flag=0;
            //遍历数组
            for (int row = 0; row < cells.length; row++) {
                for (int col = 0; col < cells[row].length; col++) {
                    Brand brands1 = brands[flag++];
                    //new对象
                    Cell cell = new Cell();
                    //设置有牌对象
                    cell.setState(1);

                    cell.setBrand(brands1);

                    brands1.setCell(cell);

                    cells[row][col]=cell;
                }
            }
            return layer;
        }
    }
