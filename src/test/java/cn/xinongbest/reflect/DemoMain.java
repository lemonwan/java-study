package cn.xinongbest.reflect;

public class DemoMain {
    public static void main(String[] args) {
        // 通过外部类间接使用内部类
        Outer outer = new Outer();
        outer.outerMethod();

        // 直接使用内部类
        Outer.Inner inner = new Outer().new Inner();
        inner.method();
    }
}
