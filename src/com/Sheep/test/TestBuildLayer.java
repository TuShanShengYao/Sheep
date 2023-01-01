package com.Sheep.test;

import com.Sheep.model.Brand;
import com.Sheep.model.Cell;
import com.Sheep.model.Layer;

import java.util.Random;

public class TestBuildLayer {
    //初始化一个随机数对象
    public static Random random = new Random();
    public  static String[] brandNames={
      "刷子","剪刀","叉子",
      "手套","水桶","火",
      "玉米","球","瓶子",
      "白菜","稻草","肉腿",
      "胡萝卜","苹果","苹果",
      "铃铛","青草"
    };
    //自定义方法getBrandName名称
    public static String getBrandName(){
        //初始化随机数名称
        int randomIndex = random.nextInt(brandNames.length);
        return brandNames[randomIndex];
    }
    public static void main(String[] args) throws Exception {
        //创建图层
        Layer l = new Layer(3,5);
//        System.out.println(getBrandName());
        //创建一个brand数组
        Brand[] brands = new Brand[l.getCapacity()];
        //for循环
        for (int i=0;i<brands.length;i=i+3){
                //每次循环获取随机牌的名称
            String randomBrandName = getBrandName();
            Brand brand1 = new Brand(randomBrandName);
            Brand brand2 = new Brand(randomBrandName);
            Brand brand3 = new Brand(randomBrandName);
            //循环36次，生成36种随机的牌
            brands[i]=brand1;
            brands[i+1]=brand2;
            brands[i+2]=brand3;
        }
        System.out.println("------打乱顺序之前---------");
        //for循环
        for(int i =0;i<brands.length;i++){
            System.out.print(brands[i].getName()+"------");
        }
        //遍历当前数组
        for (int i = 0; i < brands.length; i++) {
            //拿到当前变量A
            Brand brandA =  brands[i];
            //交换位置b的索引
            int randomIndex = random.nextInt(brands.length);
            Brand brandB =brands[randomIndex];
            //存储数组
            Brand temp = brandA;
            brands[i]=brandB;
            brands[randomIndex]=temp;
        }
        System.out.println("-----打乱顺序之后--------");
        //for循环
        for(int i =0;i<brands.length;i++){
            System.out.print(brands[i].getName()+"------");
        }
        //返回二维数组
        Cell[][] cells = l.getCells();
        /*
        *
        *
        *
        */
        //定义标记位
        int flag=0;
        //遍历数组
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                System.out.println(row+"--"+col);
                //new对象
                Cell cell = new Cell();
                //设置有牌对象
                cell.setState(1);
                cell.setBrand(brands[flag++]);
                cells[row][col]=cell;
            }
        }
        System.out.println("------输出layer图层--------");
        for (int row = 0; row <cells.length ; row++) {
            for (int col = 0; col < cells[row].length; col++) {
               Brand b =  cells[row][col].getBrand();
               System.out.print(b.getName());
            }
        }
    }
}
