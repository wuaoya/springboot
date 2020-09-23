package com.way.study.thread.controller.create;

import java.util.concurrent.*;

/**
 * 实现有返回值的callable接口开启线程
 * @Author: wuaoya
 * @Date: 2020-09-23 21:43
 */
public class CallableDemo1 implements Callable {

    public CallableDemo1(){}
    public CallableDemo1(String name){
    Thread.currentThread().setName(name);
        System.out.println("myname " + name);
    }

    @Override
    public Boolean call() throws Exception {
        if(Thread.currentThread().getName().equals("c1")){
            System.out.println("c1");
            return true;
        }else {
            System.out.println(Thread.currentThread().getName());
            return false;
        }

    }

    public static void main(String[] args) {
        CallableDemo1 c1 = new CallableDemo1("c1");
        CallableDemo1 c2 = new CallableDemo1("c2");
        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        try {
            Future<Boolean> future1 = service.submit(c1);
            Future<Boolean> future2 = service.submit(c2);
            //获取结果
            boolean rs1 = future1.get();
            boolean rs2 = future2.get();
        }catch (Exception e){
            System.out.println("抛出异常");
            e.printStackTrace();
        }
        //关闭服务
        service.shutdownNow();


    }
}
