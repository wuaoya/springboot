package com.way.study.thread.controller.create;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * runnable下载图片
 * @Author: wuaoya
 * @Date: 2020-09-22 23:09
 */
public class RunnableDemo2 implements Runnable{
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名：" + name);
    }

        private String url;
        private String name;
        //构造器
        public RunnableDemo2(){}

        public RunnableDemo2(String url,String name){
        this.url = url;
        this.name = name;
        }

    public static void main(String[] args) {
        new Thread(new RunnableDemo2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600797923907&di=f22b639b1a94c17ac33fc648f081d61a&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn%2Fw700h438%2F20180310%2Fb759-fxpwyhw6528483.jpg","4.jpg")).start();
        new Thread(new RunnableDemo2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600797923907&di=f22b639b1a94c17ac33fc648f081d61a&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn%2Fw700h438%2F20180310%2Fb759-fxpwyhw6528483.jpg","5.jpg")).start();
        new Thread(new RunnableDemo2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600797923907&di=f22b639b1a94c17ac33fc648f081d61a&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn%2Fw700h438%2F20180310%2Fb759-fxpwyhw6528483.jpg","6.jpg")).start();

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
}
