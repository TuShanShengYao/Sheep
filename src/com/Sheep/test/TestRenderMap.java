package com.Sheep.test;

import com.Sheep.model.*;
import com.Sheep.utils.MapUtil;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class TestRenderMap extends JFrame{
        public static Map map = MapUtil.buildMap(3);
        //定义构造器
        public TestRenderMap() throws HeadlessException, FileNotFoundException, JavaLayerException {
            //调用方法
            init();
            //渲染图层
            List<Layer> list = map.getList();
            for (int i = 0; i < list.size(); i++) {
                renderLayer(list.get(i));
            }
            //调用方法,游戏开始时
            map.compareAll();
            //自动刷新
            autoRefresh();
        }
        //封装方法
        private void renderLayer(Layer layer){
            //创建数组
            Cell[][] cells = layer.getCells();
            layer.showCells();
            for (int row = 0; row <cells.length ; row++) {
                for (int col = 0; col < cells[row].length; col++) {
                    Brand b =  cells[row][col].getBrand();
                    //设置坐标
                    int x = col * 50+layer.getOffsetx();
                    int y = row * 50+layer.getOffsety();
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
            this.setTitle("羊了个羊---涂山苏苏");
            //设置窗口的大小
            this.setSize(463, 860);
            //显示当前窗口位置（居中）关闭窗口，也关闭线程
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            //显示窗口界面
            //设置绝对布局
            this.setLayout(null);
            this.setBounds(0,0,463,860);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
        //自定义主方法
        public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
            //初始化TestRenderLayer方法
          TestRenderMap testRenderMap = new TestRenderMap();
            testRenderMap.init();
            //背景音乐
            new Music().music();
        }
    }
