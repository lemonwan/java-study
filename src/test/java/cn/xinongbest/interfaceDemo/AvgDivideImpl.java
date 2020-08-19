package cn.xinongbest.interfaceDemo;

import java.util.ArrayList;

/**
 * 红包平均分算法
 */
public class AvgDivideImpl implements RedPacketInterface{
    /**
     * 平均分配方法
     * @param totalMoney 总金额，使用final修饰保证不可变
     * @param totalCount 总份数，使用final修饰保证不可变
     * @return 分配结果
     */
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        // 总金额和总份数不能整除的时候，需要把剩余小数部分加到最后一个红包中
        int avgMoney = totalMoney / totalCount;
        int  leftMoney = totalMoney % totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avgMoney);
        }
        // 最后一个金额需要加上均值多余的部分
        list.add(avgMoney + leftMoney);
        return list;
    }
}
