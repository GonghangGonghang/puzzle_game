package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //LoginJFrame��ʾ��¼����
    //�Ժ����¼�йصĴ��붼д������

    public LoginJFrame(){
        //�ڴ�����¼�����ʱ��ͬʱ���������ȥ����һЩ��Ϣ
        //�罫���ֱ����ʾ����
        this.setSize(488,430);
        //���ý���ı���
        this.setTitle("ƴͼ ��¼");
        //���ý����ö�
        this.setAlwaysOnTop(true);
        //���ý������
        this.setLocationRelativeTo(null);
        //���ùر�ģʽ
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //����ʾ��ʾ������һ��д�����
        this.setVisible(true);
    }

}
