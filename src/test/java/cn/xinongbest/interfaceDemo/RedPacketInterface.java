package cn.xinongbest.interfaceDemo;

import java.util.ArrayList;

/**
 * 红包接口，主要是确定红包金额分配方式
 */
public interface RedPacketInterface {
    /**
     * 把totalMoney金额分为totalCount份
     * @param totalMoney 总金额
     * @param totalCount 总份数
     * @return 返回分红包结果
     */
    ArrayList<Integer> divide(int totalMoney, int totalCount);
}
