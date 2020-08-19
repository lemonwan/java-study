package cn.xinongbest.reflect;

import cn.xinongbest.annotation.MyAnnotation;

import java.lang.reflect.Method;

@MyAnnotation(className="cn.xinongbest.domain.User", methodName = "sleep")
public class ReflectAnno {
    public static void main(String[] args) throws Exception {
        // 获取注解内容
        MyAnnotation annotation = ReflectAnno.class.getAnnotation(MyAnnotation.class);
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);
        // 利用反射获取对象执行方法
        Class<?> cls = Class.forName(className);
        Object obj = cls.getConstructor().newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);

        // 数组反转
        int[] arr = {10, 20, 30, 40, 50};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("数组反转");
        for (int min = 0, max = arr.length - 1; min < max; min++, max--) {
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        for (int i : arr) {
            System.out.println(i);
        }

        // 数组作为参数传递
        int[] demoArr = {10, 20, 30};
        System.out.println(demoArr);
        printArr(demoArr);
        changeArray(demoArr);
        System.out.println(demoArr);
        printArr(demoArr);
    }

    /**
     * 打印数组
     * @param array
     */
    public static void changeArray(int[] array) {
        array[1] = 200;
    }

    public static void printArr(int[] array) {
        for (int x: array) {
            System.out.println(x);
        }
    }
}
