package cn.xinongbest.interfaceDemo;

import java.util.ArrayList;
import java.util.Random;

/**
 * 随机红包：最少1分钱，最多是平分的2倍
 */
public class RandomDivideImpl implements RedPacketInterface {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int changeMoney = totalMoney;
        int changeCount = totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            int money = new Random().nextInt(changeMoney / changeCount * 2) + 1;
            arrayList.add(money);
            changeCount -= 1;
            changeMoney -= money;
        }
        arrayList.add(changeMoney);
        return arrayList;
    }
}
