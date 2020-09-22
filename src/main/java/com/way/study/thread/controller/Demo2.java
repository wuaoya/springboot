package com.way.study.thread.controller;

/**
 * 实现runnable接口
 * 作为线程任务存在
 * @Author: wuaoya
 * @Date: 2020-09-18 22:15
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("Thread running 。。。");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.start();
    }
}
