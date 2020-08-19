package cn.xinongbest.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * java反射练习
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        // 获取读取配置文件的类对象
        Properties pro = new Properties();
        // 获取配置文件
        InputStream in = ReflectDemo.class.getClassLoader().getResourceAsStream("pro.properties");
        pro.load(in);
        // 获取配置文件的内容
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        // 利用反射获取类对象
        Class cls = Class.forName(className);
        Object obj = cls.getConstructor().newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
