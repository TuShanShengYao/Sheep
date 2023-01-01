package com.Sheep.test;

import com.Sheep.model.Brand;
import com.Sheep.model.Cell;
import com.Sheep.model.Layer;
import com.Sheep.model.Music;
import com.Sheep.utils.LayerUtil;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.io.FileNotFoundException;

public class TestRenderLayer extends JFrame {
    private Layer layer = LayerUtil.build(6,6);
    //定义构造器
    public TestRenderLayer() throws FileNotFoundException, JavaLayerException {
        //调用方法
        init();
        //渲染图层
        renderLayer();
        //自动刷新
        autoRefresh();
        //背景音乐
        for (int j = 0; j <= 15; j++) {
            new Music().music();
        }
    }
    //封装方法
    private void renderLayer(){
        //创建数组
        Cell[][] cells = layer.getCells();
        for (int row = 0; row <cells.length ; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand b =  cells[row][col].getBrand();
                //设置坐标
                int x = col * 50;
                int y = row * 50;
                b.setBounds(x,y,50,50);

                this.getContentPane().add(b);
            }
        }
    }
    //定义一个自动刷新方法
    private void autoRefresh() {
        //创建一个局部变量
        JFrame start = this;
        //新建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    start.repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    //初始化窗口
    public  void init(){
        //设置游戏的名字
        this.setTitle("羊了个羊----涂山苏苏");
        //设置窗口的大小
        this.setSize(463, 860);
        //显示当前窗口位置（居中）关闭窗口，也关闭线程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //显示窗口界面
        //设置绝对布局
        this.setLayout(null);
        this.setBounds(0,0,463,860);
        this.setVisible(true);
    }
    //自定义主方法
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        //初始化TestRenderLayer方法
        TestRenderLayer testRenderLayer = new TestRenderLayer();
        testRenderLayer.init();
    }
}
