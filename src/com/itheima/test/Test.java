package com.itheima.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //��һ��һά����0~15 ����˳��
        //�ĸ�һ������ά������
        //1.����һ��һά����
        int [] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //2.�������������ݵ�˳��
        //�������飬�õ�ÿһ��Ԫ�أ�����ÿһ��Ԫ������������ϵ����ݽ��н���
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        //����һ����ά����
        int [][] data = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
    }
}
