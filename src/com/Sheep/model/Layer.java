package com.Sheep.model;

import java.util.Random;

/*
    图层类

    二维表格
*/
public class Layer {
    //偏移量 x
    private Integer offsetx;
    //偏移量 y
    private Integer offsety;
    //有多少行
    private Integer rowNum;
    //有多少列
    private Integer colNum;
    //当前图层能容纳牌的数量
    private Integer capacity;
    //设置牌.当牌添加的时候，需要改变。当牌减少的时候，也需要改变
    private Integer size;
    //上一层图层对象
    private Layer parent;
    private Cell[][] cells=null;
    public Integer getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(Integer offsetx) {
        this.offsetx = offsetx;
    }

    public Layer(Integer rowNum, Integer colNum) throws Exception {
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.capacity = this.rowNum*this.colNum;
        //if判断容量不等于3的倍数
        if(this.capacity%3!=0){
                throw new Exception("容量不是三的倍数");
        }
        //初始化行列
        this.cells = new Cell[this.rowNum][this.colNum];
        this.size=0;
        //设置偏移量的随机数为100
        this.offsetx = new Random().nextInt(100);
        this.offsety = new Random().nextInt(100);
    }
    public void showCells(){
        for (int row = 0; row <cells.length ; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand b =  cells[row][col].getBrand();
                System.out.print(b.getName()+"-");
            }
            System.out.println();
        }
    }
    public Cell[][] getCells() {
        return cells;
    }

    public Integer getOffsety() {
        return offsety;
    }

    public void setOffsety(Integer offsety) {
        this.offsety = offsety;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
