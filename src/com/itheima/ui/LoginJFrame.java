package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //LoginJFrame表示登录界面
    //以后与登录有关的代码都写在这里

    public LoginJFrame(){
        //在创建登录界面的时候，同时给这个界面去设置一些信息
        //如将宽高直接显示出来
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //让显示显示出来，一般写在最后
        this.setVisible(true);
    }

}
