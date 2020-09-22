package com.way.study.thread.controller.create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Thread 多线程下载图片
 * @Author: wuaoya
 * @Date: 2020-09-22 22:39
 */
public class Demo2 extends Thread{
    //构造器
    public Demo2(){}
    public Demo2(String url,String name){
        this.url = url;
        this.name = name;
    }

    //图片url
    private String url;
    //文件名
    private String name;

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载完成！文件名：" + name);
    }

    public static void main(String[] args) {
        Demo2 d1 = new Demo2("http://pic1.win4000.com/pic/9/36/e4a5cbcfd9.jpg","1.jpg");
        Demo2 d2 = new Demo2("http://pic1.win4000.com/pic/9/36/e4a5cbcfd9.jpg","2.jpg");
        Demo2 d3 = new Demo2("http://pic1.win4000.com/pic/9/36/e4a5cbcfd9.jpg","3.jpg");
        d1.start();
        d2.start();
        d3.start();
     }

}

class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io error,downloader");
        }
    }
}