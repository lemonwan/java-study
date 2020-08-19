package cn.xinongbest.interfaceDemo;

public class MyInterfaceDemoMain {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void methodAbs() {
                System.out.println("匿名内部类覆写方法");
            }

            @Override
            public void method() {
                System.out.println("匿名内部类第二个方法");
            }
        };
        myInterface.methodAbs();
        System.out.println(myInterface.age);


        MyLamda myLamda = () -> System.out.println("Lamda表达式语法");
        myLamda.method();
    }
}
