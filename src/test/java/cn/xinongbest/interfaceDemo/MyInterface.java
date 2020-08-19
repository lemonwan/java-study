package cn.xinongbest.interfaceDemo;

/**
 * 1、接口的内容（不同的JDK版本，接口的内容是不一样的）：
 * java7：
 *      常量
 *      抽象方法
 * java8：
 *      默认方法
 *      静态方法
 * java9：
 *      私有方法
 * 2、接口中的抽象方法必须只能是public和abstract修饰，所以可以省略；
 */
public interface MyInterface {
    // 接口常量  | 关键字 public static final 可以省略不写
    public static final int age = 10;
    // 接口抽象方法
    public abstract void methodAbs();
    // 默认方法
//     public default void method1(){
//        System.out.println("111");
//    }
    void method();
}
