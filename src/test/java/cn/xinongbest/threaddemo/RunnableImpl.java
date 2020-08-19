package cn.xinongbest.threaddemo;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行任务");
    }
}
