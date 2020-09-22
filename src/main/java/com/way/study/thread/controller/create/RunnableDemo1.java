package com.way.study.thread.controller.create;

/**
 * 实现runnable创建线程
 * @Author: wuaoya
 * @Date: 2020-09-22 23:02
 */
public class RunnableDemo1 implements Runnable{
    @Override
    public void run() {
        System.out.println("线程开启");
    }

    public static void main(String[] args) {
        //通过匿名对象代理开启线程
        new Thread(new RunnableDemo1()).start();
    }
}
