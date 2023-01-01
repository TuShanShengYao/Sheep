package com.Sheep.view;

import com.Sheep.model.Brand;

import javax.swing.*;
import java.awt.*;

/*
 * 游戏的启动入口
 */

public class Start extends JFrame {
    //创建brand对象
    private Brand brand = new Brand("刷子");

    //创造一个无参构造器
    public Start() throws HeadlessException {
        //设置游戏的名字
        this.setTitle("羊了个羊 版权所有 涂山苏苏");
        //设置窗口的大小
        this.setSize(400, 800);
        //显示当前窗口位置（居中）关闭窗口，也关闭线程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //显示窗口界面
        this.setVisible(true);
        //添加组件方法
        //添加自定义的组件，到当前的窗口
//        brand.setGray(true);
        this.getContentPane().add(brand);
        //启用自动刷新线程
        autoRefresh();
    }

    //定义一个自动刷新方法
    private void autoRefresh() {
        //创建一个局部变量
        Start start = this;
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

    public static void main(String[] args) {
        //创建Start对象
        Start s = new Start();
    }
}
