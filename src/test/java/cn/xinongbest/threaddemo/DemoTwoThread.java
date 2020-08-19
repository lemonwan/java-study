package cn.xinongbest.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoTwoThread {
    public static void main(String[] args) {
        // threadTest();
        // Thread.currentThread().setDaemon(true);
        // checkThread();
        threadPool();
    }

    public static void threadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new RunnableImpl());
        threadPool.submit(new RunnableImpl());
        threadPool.submit(new RunnableImpl());
    }


    public static void threadTest() {
        Object obj = new Object();
        new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("消费者通知生产者生产数据");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费者消费完成");
                }
            }
        }.start();

        new Thread(()->{
            synchronized (obj) {
                System.out.println("生产者开始生产数据，大约需要5秒钟时间");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产结束，通知消费之消费");
                obj.notify();
            }
        }).start();
    }

    public static void checkThread() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "====>开始执行");
        new Thread(()->{
            String nameOne = Thread.currentThread().getName();
            System.out.println(nameOne + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nameOne + "结束执行");
        }).start();
        new Thread(()->{
            String nameTwo = Thread.currentThread().getName();
            System.out.println(nameTwo + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nameTwo + "结束执行");
        }).start();
        System.out.println(name + "====>结束执行");
    }
}
