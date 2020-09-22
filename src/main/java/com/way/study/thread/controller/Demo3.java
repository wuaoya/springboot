package com.way.study.thread.controller;

/**
 * @Author: wuaoya
 * @Date: 2020-09-18 22:33
 */
public class Demo3 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("thread start ..")).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thead");
            }
        });
    }
}
