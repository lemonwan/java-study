package cn.xinongbest.threaddemo;

import java.util.concurrent.BlockingQueue;

public class Consumer {
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.79) {
            return false;
        }
        return  true;
    }
}
