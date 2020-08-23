package cn.xinongbest.interfaceDemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        String[] arr = {"aa", "b", "ccc"};
        Arrays.sort(arr, sortStringByLength());
        System.out.println(Arrays.toString(arr));

        // 调用方法
        System.out.println(getString(() -> "hello"));

        // 函数式接口：java.util.function.Supplier供给型接口 get()抽象方法

        // 函数式接口：java.util.function.Consumer消费型接口 accept()抽象方法  andThen()默认方法

        // 函数式接口：java.util.function.Predicate断言型接口 test()抽象方法 and() or() negate()
        // 案例：判断给定字符串长度是否大于等于5，且包含字符串a
        boolean b = predicateMethod("b1cde", (str) -> str.length() >= 5, (str) -> str.contains("a"));
        System.out.println(b);

        // 函数式接口：java.util.function.Function功能型接口 apply()抽象方法
        // 案例：把字符串数字转换成数字，并且加上10，然后再转换成字符串
        String s = functionMethod("1234567", (str) -> Integer.parseInt(str) + 10, (num) -> String.valueOf(num));
        System.out.println(s);
    }

    /**
     * 函数式接口做为方法的返回值
     */
    public static Comparator<String> sortStringByLength() {
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static String  getString(Supplier<String> s) {
        return s.get();
    }

    public static String functionMethod(String string, Function<String,Integer> fun1,Function<Integer,String> fun2) {
        return fun1.andThen(fun2).apply(string);
    }

    public static boolean predicateMethod(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(str);
    }


}
