package com.Sheep.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    //创建音乐
    public void music() throws FileNotFoundException, JavaLayerException {
        //获取当前音乐的背景音乐的地址
        String str = System.getProperty("user.dir")+"/music/羊了个羊.mp3";
        //创建BufferedInputStream对象
        BufferedInputStream b = new BufferedInputStream(new FileInputStream(str));
        Player p = new Player(b);
        p.play();
    }
}
