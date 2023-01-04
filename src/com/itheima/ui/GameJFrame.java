package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //JFrame���������ʾ���棬����
    //�涨��GameJFrame��������ʾ�ľ�����Ϸ��������
    //�Ժ����Ϸ�йص��߼���д���������

    //����һ����ά����
    //Ŀ�ģ���������  ����ͼƬʱ���ݶ�ά��������ݽ��м���
    int [][] data = new int[4][4];
    //x y Ϊ0�ڶ�ά�����е�λ��
    int x = 0;
    int y = 0;
    //����һ�����������ڼ�¼��ǰչʾͼƬ��·��
    String path = "..\\puzzlegame\\image\\girl\\girl1\\";
    //����һ����ά����洢��ȷ������
    int [][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0},
    };
    //�����������ͳ�Ʋ���
    int step = 0;
    //�����������Ŀ����
    JMenuItem replayItem = new JMenuItem("������Ϸ");
    JMenuItem reLoginItem = new JMenuItem("���µ�¼");
    JMenuItem closeItem = new JMenuItem("�ر���Ϸ");

    JMenuItem accountItem = new JMenuItem("���ں�");
    public GameJFrame(){
        //��ʼ������
        initJFrame();

        //��ʼ���˵�
        initJMenuBar();

        ///��ʼ�����ݣ����ң�
        initData();

        //��ʼ��ͼƬ
        initImage();

        //����ʾ��ʾ������һ��д�����
        this.setVisible(true);
    }


    private void initData() {
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


        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i] == 0){
                x = i / 4; y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    //��ʼ��ͼƬ
    //���ͼƬʱ�����ն�ά���������ݵ�˳��������
    private void initImage() {
        //���ԭ���Ѿ����ֵ�����ͼƬ
        this.getContentPane().removeAll();
        if(victory()){
            //��ʾʤ����ͼ��
            JLabel winJLable = new JLabel(new ImageIcon("..\\puzzlegame\\image\\win.png"));
            winJLable.setBounds(203,283,197,73);
            this.getContentPane().add(winJLable);
        }
        JLabel stepCount = new JLabel("������" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);
        //ϸ�ڣ��ȼ��ص�ͼƬ���Ϸ�������ص�ͼƬ���·�
        //��ˣ�������ϷͼƬ��������ͼƬ
        //int number = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //����һ��ͼƬImageIcon�Ķ���
                //����һ��JLable�Ķ��󣨹���������
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                //ָ��ͼƬλ��
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //��ͼƬ��ӱ߿�
                //0����ʾ��ͼƬ͹����
                //1����ʾ��ͼƬ����ȥ
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //�ѹ���������ӵ�������
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
                //number++;
            }
        }

        //��ӱ���ͼƬ
        ImageIcon bg = new ImageIcon("..\\puzzlegame\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,508,560);
        //�ѱ���ͼƬ��ӵ���ǰ������
        this.getContentPane().add(background);

        //ˢ��һ�½���
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //��ʼ���˵�
        //���������Ĳ˵�����
        JMenuBar jMenuBar = new JMenuBar();

        //�����˵���������ѡ��Ķ���
        JMenu funcationJMenu = new JMenu("����");
        JMenu aboutJMenu = new JMenu("��������");


        //����Ŀ�������ѡ����
        funcationJMenu.add(replayItem);
        funcationJMenu.add(reLoginItem);
        funcationJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //����Ŀ���¼�
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //���˵��е�����ѡ�����˵���
        jMenuBar.add(funcationJMenu);
        jMenuBar.add(aboutJMenu);

        //�������������ò˵�
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //���ý���Ŀ��
        this.setSize(603,680);
        //���ý���ı���
        this.setTitle("ƴͼ������ v1.0");
        //���ý����ö�
        this.setAlwaysOnTop(true);
        //���ý������
        this.setLocationRelativeTo(null);
        //���ùر�ģʽ
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ȡ��Ĭ�ϵľ���
        this.setLayout(null);
        //������������Ӽ��̼����¼�
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //���²���ʱ�����������
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==65){
            //�ѽ���������ͼƬȫ��ɾ��
            this.getContentPane().removeAll();
            //���ص�һ��������ͼƬ
            JLabel all=new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //���ر���ͼƬ
            ImageIcon bg = new ImageIcon("..\\puzzlegame\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40,40,508,560);
            //�ѱ���ͼƬ��ӵ���ǰ������
            this.getContentPane().add(background);
            //ˢ��һ�½���
            this.getContentPane().repaint();
        }
    }

    //�ɿ�������ʱ������������
    @Override
    public void keyReleased(KeyEvent e) {
        //�ж���Ϸ�Ƿ�ʤ�������ʤ�����˷�����Ҫֱ�ӽ���
        if(victory()) return;
        //���������ҽ����ж�
        //��37 �ϣ�38 �ң�39 �£�40
        //A:65  W:87  D:68  S:83
        int code = e.getKeyCode();
        //System.out.println(code);
        if(code == 37){
            System.out.println("�����ƶ�");
            if(y == 3) return;
            //x y ��ʾ�հ׷����λ��
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            //���÷��������������ݼ���ͼƬ
            initImage();
        }else if(code == 38){
            System.out.println("�����ƶ�");
            if(x == 3) return;
            //�ѿհ׷����·������ָ�ֵ���հ׷����Ϸ�
            //x y ��ʾ�հ׷����λ��
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            //���÷��������������ݼ���ͼƬ
            initImage();
        }else if(code == 39){
            System.out.println("�����ƶ�");
            if(y == 0) return;
            //x y ��ʾ�հ׷����λ��
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            //���÷��������������ݼ���ͼƬ
            initImage();
        }else if(code == 40){
            System.out.println("�����ƶ�");
            if(x == 0) return;
            //x y ��ʾ�հ׷����λ��
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            //���÷��������������ݼ���ͼƬ
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    //�ж�data�����е����ݺ�win�����е��Ƿ���ͬ
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if(data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            System.out.println("���¿�ʼ");
            //�Ʋ������㣨����֮ǰ��
             step = 0;
            //�ٴδ��Ҷ�ά�����е�����
            initData();
            //���¼���ͼƬ
            initImage();

        } else if (obj == reLoginItem) {
            System.out.println("���µ�¼");
            //�رյ�ǰ��Ϸ����
            this.setVisible(false);
            //�򿪵�¼����
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("�ر���Ϸ");
            //ֱ�ӹر������
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("���ں�");
            //����һ���������
            JDialog jDialog = new JDialog();
            //����һ������ͼƬ����������
            JLabel jLable = new JLabel(new ImageIcon("..\\puzzlegame\\image\\gh.png"));
            //����λ�úͿ��
            jLable.setBounds(0,0,258,258);
            //��ͼƬ��ӵ�������
            jDialog.getContentPane().add(jLable);
            //���������ô�С
            jDialog.setSize(344,344);
            //�õ����ö�
            jDialog.setAlwaysOnTop(true);
            //�õ������
            jDialog.setLocationRelativeTo(null);
            //���򲻹ر����޷�������������
            jDialog.setModal(true);
            //�õ�����ʾ����
            jDialog.setVisible(true);
        }
    }
}
