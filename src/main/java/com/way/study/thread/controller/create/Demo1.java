package com.way.study.thread.controller.create;

/**
 * 创建线程继承thread类
 * 线程是同时执行的，cpu分配时间片
 * @Author: wuaoya
 * @Date: 2020-09-22 22:28
 */
public class Demo1 extends Thread{
    @Override
    public void run() {
        //run
        for (int i = 0; i < 20; i++) {
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程---" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        Demo1 demo1 = new Demo1();

        //调用start方法开启线程
        demo1.start();

        for (int i = 0; i <20 ; i++) {
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程---" + i);
        }
    }

}
