package cn.xinongbest.list;

import cn.xinongbest.domain.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DemoArray {
    public static void main(String[] args) {
        stringHandle();
        // randomDemo();
        // studentDemo();
    }

    /**
     * 产生6个随机数，并添加到集合，然后遍历
     */
    public static void randomDemo() {
        List<Integer> list = new ArrayList<Integer>();
        Random ran = new Random();
        for (int i = 0; i < 6; i++) {
            list.add(ran.nextInt(33) + 1);
        }
        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void studentDemo() {
        List<Student> studentList = new ArrayList<Student>();
        // 生成Student对象
        Student stuOne = new Student("张三", 100, "男", 20);
        Student stuTwo = new Student("李四", 101, "女", 21);
        Student stuThree = new Student("王五", 102, "男", 22);
        Student stuFour = new Student("赵六", 103, "女", 23);
        // 向集合添加
        studentList.add(stuOne);
        studentList.add(stuTwo);
        studentList.add(stuThree);
        studentList.add(stuFour);
        // 遍历集合
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 字符串的操作方法：
     * public int length() : 返回字符串的长度
     * public String concat(String str) : 字符串的拼接
     * public char charAt(int i) : 获取指定位置的字符
     * public int indexOf() : 获取指定字符串开始的索引位置
     * public String substring() : 字符串截取（该方法有两种重载形式：指定开始截取的位置，默认到最后；指定开始和结束的截取位置，不包含结束位置的字符）
     * public char[] toCharArray() : 获取字符串的字符数组
     * public byte[] getBytes() : 获取字符串的字节数组
     * public String replace(CharSequence oldString, CharSequences newString) : 字符串替换
     * public String[] split(String regx) : 字符串的切割方法（注意：切割参数是一个正则表达式，如果用英文的据点，正好是正则中的一个元字符，需要特别注意）
     */
    public static void stringHandle() {
        // 忽略字母大小写检查字符创是否相等
        boolean ignoreCase = "abc".equalsIgnoreCase("ABC");
        if (ignoreCase) {
            System.out.println("abc");
        }
        // public char charAt()
        System.out.println("abc".charAt(1));
        // public int indexOf()
        String str = "Hello World";
        int index  = str.indexOf("World");
        System.out.println(index);
        // public String substring()
        System.out.println("synchronized".substring(5));
    }

}
