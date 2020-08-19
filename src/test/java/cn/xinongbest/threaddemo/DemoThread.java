package cn.xinongbest.threaddemo;

public class DemoThread implements Runnable {
    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled && num <= 10000) {
                if (num % 10 == 0) {
                    System.out.println(num + "是10的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DemoThread t = new DemoThread();
        Thread thread = new Thread(t);
        thread.start();
        Thread.sleep(3000);
        t.canceled = true;
    }
}
