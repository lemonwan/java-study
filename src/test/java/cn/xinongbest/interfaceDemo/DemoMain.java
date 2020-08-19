package cn.xinongbest.interfaceDemo;

public class DemoMain {
    public static void main(String[] args) {
        // 实例化对象
        DemoFirst demoFirst = new DemoFirst();
        // 设置对应值
        demoFirst.setName("Hello");
        // 使用匿名对象设置值
        demoFirst.setMyInterface(new MyInterface() {
            @Override
            public void methodAbs() {
                System.out.println("Hello World");
            }

            @Override
            public void method() {
                System.out.println("Hi");
            }
        });
        // 使用Lamda表达式
        demoFirst.setMyLamda(() -> System.out.println("Hi, Lamda"));
        // 获取值或者输出
        System.out.println(demoFirst.getName());
        demoFirst.getMyInterface().methodAbs();
        demoFirst.getMyInterface().method();
        demoFirst.getMyLamda().method();
    }
}
