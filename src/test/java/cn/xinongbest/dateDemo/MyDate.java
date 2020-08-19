package cn.xinongbest.dateDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * java.util.Date 直接输出Date对象，可以得到当前的时间
 * 需要注意的方法：无参构造、有参构造（long型的时间戳）、getTime()方法
 */
public class MyDate {
    public static void main(String[] args) {
        // 直接输出Date对象
        Date date = new Date();
        System.out.println(date);
        // 获取系统当前时间戳
        System.out.println(System.currentTimeMillis());
        // 获取指定时间戳的日期
        System.out.println(new Date(0L));
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date(1595151714004L));
        // 获取当前时间戳
        System.out.println(new Date().getTime());

        // 调用泛型方法
        genericMethod("hello");

        System.out.println(0 % 3);
        System.out.println(1 % 3);
        System.out.println(2 % 3);

        // 使用多态的时候不能使用子类特有的方法
        Collection<String> coll = new ArrayList<>();
        coll.add("Hello");
        System.out.println(coll);
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add(14,"Hello");
        System.out.println(list);
    }

    // 泛型方法
    public static <M> void genericMethod(M m) {
        System.out.println(m);
    }
}
