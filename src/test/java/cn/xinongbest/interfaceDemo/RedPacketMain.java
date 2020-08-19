package cn.xinongbest.interfaceDemo;

import java.util.ArrayList;

public class RedPacketMain {
    public static void main(String[] args) {
        // 红包发放中最少是1分钱，所以为了便于计算，把钱的单位转换为分
        // 设置红包总金额和红包个数：10元钱和3份
        int totalMoney = 1000;
        int totalCount = 3;
        System.out.println("均分红包");
        AvgDivideImpl avgDivide = new AvgDivideImpl();
        ArrayList<Integer> list =  avgDivide.divide(totalMoney, totalCount);
        // 取出的时候需要把单位转换成元
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("随机红包");
        RandomDivideImpl randomDivide = new RandomDivideImpl();
        ArrayList<Integer> randPacket =  randomDivide.divide(totalMoney, totalCount);
        for (int i = 0; i < randPacket.size(); i++) {
            System.out.println(randPacket.get(i));
        }
    }
}
