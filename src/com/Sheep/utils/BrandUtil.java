package com.Sheep.utils;

import com.Sheep.model.Brand;

import java.util.Random;

/*
*
*
* 工具类
* 提供一些公共方法、类
*
*/
public class BrandUtil {
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
    //创建随机牌的数组
    public static Brand[] buildBrands(Integer capacity){
        //创建一个brand数组
        Brand[] brands = new Brand[capacity];
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
        //for循环
        for(int i =0;i<brands.length;i++){
            System.out.print(brands[i].getName()+"------");
        }
        return brands;
    }
}