package com.itheima.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //将一个一维数组0~15 打乱顺序
        //四个一组放入二维数组中
        //1.定义一个一维数组
        int [] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //2.打乱数组中数据的顺序
        //遍历数组，得到每一个元素，拿着每一个元素与随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        //创建一个二维数组
        int [][] data = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
    }
}
