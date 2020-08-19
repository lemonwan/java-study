package cn.xinongbest.interfaceDemo;

public class DemoFirst {
    private String name;

    private MyInterface myInterface;

    private MyLamda myLamda;

    public DemoFirst() {
    }

    public DemoFirst(String name, MyInterface myInterface, MyLamda myLamda) {
        this.name = name;
        this.myInterface = myInterface;
        this.myLamda = myLamda;
    }

    /**
     * 覆写Object的equals方法的时候会涉及到多态问题，一定要注意向下转型
     * 注意：判断比较的对象是不是null，是不是自己，是不是本类对象（避免向下转型出现ClassCastException）
     * @param obj 对象比较
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return  false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof DemoFirst) {
            if (this.name.equals(((DemoFirst) obj).name)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyInterface getMyInterface() {
        return myInterface;
    }

    public void setMyInterface(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public MyLamda getMyLamda() {
        return myLamda;
    }

    public void setMyLamda(MyLamda myLamda) {
        this.myLamda = myLamda;
    }
}
