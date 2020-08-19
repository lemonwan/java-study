package cn.xinongbest.threaddemo;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    public volatile boolean canceled = false;

    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 10;
        try {
            while (!canceled && num <= 10000) {
                if (num % 50 == 0) {
                    this.storage.put(num);
                    System.out.println(num + "是50的倍数，已经放入队列中，等待消费");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束运行");
        }
    }
}
