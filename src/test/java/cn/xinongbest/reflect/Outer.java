package cn.xinongbest.reflect;

/**
 * Java访问修饰符：
 * public protected (default) private
 * 同一个类
 * 同一包
 * 不同包继承关系
 * 不同包非继承关系
 * --------------------------------------------
 * 内部类：成员内部类 匿名内部类
 */
public class Outer {

    public class Inner {

        private int num = 2;

        public void method() {
            System.out.println("内部类方法");
            System.out.println(Outer.this.name);
        }

        public void getNum() {
            int num = 3;
            System.out.println("局部：" + num);
            System.out.println("成员：" + this.num);
            System.out.println("外部：" + Outer.this.num);
        }
    }

    private int num = 1;
    private String name = "Hello";

    public void outerMethod() {
        System.out.println("外部类方法");
        new Inner().method();
    }

    /**
     * 注意：局部内部类不能用任何修饰符修饰
     */
    public void demoMethod() {
        // 局部内部类定义
        class Inner {
            int num = 10;
            public void method() {
                System.out.println("局部内部类");
            }
        }
        // 使用
        Inner inner = new Inner();
        inner.method();
    }
}
