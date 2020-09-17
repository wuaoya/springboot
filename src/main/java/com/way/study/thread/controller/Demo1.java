package com.way.study.thread.controller;

/**
 * 线程学习1
 * 继承thread类创建，启动，中断线程
 * @Author: wuaoya
 * @Date: 2020-09-17 21:46
 */
public class Demo1 extends Thread{
    //run() 方法当作普通方法的方式调用。程序还是要顺序执行，要等待run方法体执行完毕后，才可继续执行下面的代码； 程序中只有主线程——这一个线程， 其程序执行路径还是只有一条， 这样就没有达到写线程的目的。
    //start() 方法来启动线程，真正实现了多线程运行。这时无需等待run方法体代码执行完毕，可以直接继续执行下面的代码；通过调用Thread类的start()方法来启动一个线程， 这时此线程是处于就绪状态， 并没有运行。 然后通过此Thread类调用方法run()来完成其运行操作的， 这里方法run()称为线程体，它包含了要执行的这个线程的内容， Run方法运行结束， 此线程终止。然后CPU再调度其它线程。
    //interrupted() 线程是否被中断
    //interrupt() 将线程中断
    //setDaemon(true) 将当前线程设置为守护线程，做支持性工作,当主线程执行完毕时，线程也跟随主线程结束（不管线程是否执行完毕）
    //sleep() 给线程设置休眠时间，默认毫秒


    //构造方法
    public Demo1(String name){
        super(name);
    }

    @Override
    public void run() {

        while (!interrupted()){
            System.out.println(getName() + "线程执行。。。");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        Demo1 d1 = new Demo1("first-thread");
        Demo1 d2 = new Demo1("second-thread");

        //守护线程，做支持性工作,当主线程执行完毕时，线程也跟随主线程结束（不管线程是否执行完毕）
//        d1.setDaemon(true);
//        d2.setDaemon(true);

        d1.start();
        d2.start();

        //线程中断
        d1.interrupt();
        //将线程停止，但是线程处于无限期的等待过程，持有锁和资源没有释放，所以要舍弃这种方法
//        d1.stop();

//        try {
        //线程睡眠
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
