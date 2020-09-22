package com.way.study.thread.controller.create;


/**
 * 多个线程操作同一个对象
 * 龟兔赛跑
 * @Author: wuaoya
 * @Date: 2020-09-22 23:23
 */
public class RunnableDemo3 implements Runnable{
    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            //判断比赛是否结束
            if(Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() +"跑了" +  i);
        }
    }

    private boolean gameOver(int setp){
        if(winner!=null){
            return true;
        }{
            if(setp >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RunnableDemo3 runnableDemo3 = new RunnableDemo3();
        new Thread(runnableDemo3,"乌龟").start();
        new Thread(runnableDemo3,"兔子").start();

    }
}
