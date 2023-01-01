package com.Sheep.model;

import com.Sheep.test.TestRenderMap;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
* brand代表游戏里面的一张牌
*/
public class Brand extends Component {
    //牌的名称
    private String name;
    //检查牌是否为灰色
    private Boolean isGray;
    //正常的图片
    private Image image;
    //灰色的图片
    private  Image grayImage;
    //设置x、y坐标代表渲染当前
    private Integer x;
    private Integer y;
    //设置宽高
    private Integer width;
    private Integer height;
    private Cell cell;
    //自定义一个有参构造
    public Brand (String name){
        this.name=name;
        //传图片
        this.image=Toolkit.getDefaultToolkit().getImage("img\\"+name+".png");
        this.grayImage=Toolkit.getDefaultToolkit().getImage("img\\"+name+"_gray.png");

        this.isGray = false;
        //设置图片宽高
        this.width=50;
        this.height=50;
        //设置x轴和y轴，默认为0
        this.x=0;
         this.y=0;
         //鼠标监听
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Brand.mouseClick");
                    //获取当前的组件
                Brand brand = (Brand) e.getSource();
                //通过父容器删掉自己
               if(brand.getGray()){
                   //灰色
                   return;
               }
               else{
                   brand.getParent().remove(brand);
                   //解决bug
//                   cell.setState(0);
//                   cell.setBrand(null);
                   TestRenderMap.map.compareAll();
               }
            }
        });
    }

    //重写绘画方法
    @Override
    public void paint(Graphics g) {
        //判断
        if(isGray==true){
            //绘制灰色图片
            g.drawImage(this.grayImage,this.x,this.y,null);
        }else{
            //绘制正常图片
            g.drawImage(this.image,this.x,this.y,null);
        }
    }
        //生成x、y、width、height Set和Get方法

    public Boolean getGray() {
        return isGray;
    }

    public void setGray(Boolean gray) {
        isGray = gray;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Image getImage() {

        return image;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setImage(Image image) {

        this.image = image;
    }

    public Image getGrayImage() {

        return grayImage;
    }

    public void setGrayImage(Image grayImage) {

        this.grayImage = grayImage;
    }
    public String getName(){
        return name;
    }
}
