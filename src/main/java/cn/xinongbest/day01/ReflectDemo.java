package cn.xinongbest.day01;

import java.lang.reflect.Method;

/**
 * @author wzj
 */
@MyAnno(className = "cn.xinongbest.day01.Student", methodName = "study")
public class ReflectDemo {

    public String reflectHandle() throws Exception {
        // 获取本类的Class类对象
        Class<ReflectDemo> demoClass = ReflectDemo.class;
        // 通过本类的Class类对象获取注解类对象
        // 关键：注解的本质是接口，该步骤的本质是jvm在内存中生成了一个实现自定义注解MyAnno接口的对象，并实现了定义的抽象方法
        MyAnno anno = demoClass.getAnnotation(MyAnno.class);
        // 通过返回的实现MyAnno接口对象调用方法，返回对应的值
        String className = anno.className();
        String methodName = anno.methodName();
        // 通过类名获取给定的类的Class类对象
        Class aClass = Class.forName(className);
        // 通过Class类对象产生类实例
        Object o = aClass.getConstructor().newInstance();
        // 通过Class类对象获取本类的指定的方法对象
        Method method = aClass.getMethod(methodName);
        // 通过方法实例、指定的类对象组合调用对应的方法
        return (String) method.invoke(o);
    }
}
