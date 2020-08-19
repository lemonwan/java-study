package cn.xinongbest.file;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        // methodTwo();
        // methodOne();
        // methodThree();
        // methodFour();
        // methodFive();
        // copyImage();
        transferStream();
        transferStreamNew();
        transferOutputStream();
    }

    /**
     * 字符输出流
     */
    public static void transferOutputStream() {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("W:\\JAVA\\maven_mybatis\\写文件.txt"), "GBK")) {
            writer.write("你好，中国");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定字符编码，字符输入流
     */
    public static void transferStreamNew() {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("W:\\JAVA\\maven_mybatis\\中文GBK编码文件.txt"), "GBK")){
            // 字符数组读取
            int len;
            char[] chars = new char[1024];
            while ((len = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }
            // 单个字节读取
           /* int code;
            while ((code = reader.read()) != -1) {
                System.out.println((char)code);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用FileReader字符输入流只能按照IDE默认的编码读取，不能指定解码字符集
     * 字符转换流
     */
    public static void transferStream() {
        try (FileReader reader = new FileReader("W:\\JAVA\\maven_mybatis\\中文GBK编码文件.txt")) {
            int len;
            while ((len = reader.read()) != -1) {
                System.out.println((char)len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片复制
     */
    public static void copyImage() {
        try {
            FileInputStream stream = new FileInputStream("W:\\JAVA\\maven_mybatis\\java.png");
            FileOutputStream outputStream = new FileOutputStream("W:\\JAVA\\maven_mybatis\\copy.png", true);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = stream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            stream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节输入流一次读入多个字节
     */
    public static void methodFive() {
        try {
            FileInputStream stream = new FileInputStream("W:\\JAVA\\maven_mybatis\\test.txt");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = stream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节输入流每次读取一个字节
     */
    public static void methodFour() {
        try {
            FileInputStream stream = new FileInputStream("W:\\JAVA\\maven_mybatis\\a.txt");
            int b;
            while ((b = stream.read()) != -1) {
                System.out.print((char) b);
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断文件是否存在，然后执行删除逻辑；
     * 写入文件数据，并做追加和换行；
     */
    public static void methodThree() {
        File file = new File("test.txt");
        if (file.exists()) {
            file.delete();
        }
        for (int i = 0; i < 10; i++) {
            try {
                FileOutputStream stream = new FileOutputStream(file, true);
                stream.write("你好，世界！！".getBytes());
                stream.write("\r\n".getBytes());
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void methodOne() {
        System.out.println(File.separator); // \
        System.out.println(File.pathSeparator); // ;
    }

    /**
     * String getAbsolutePath()
     */
    public static void methodTwo() {
        File file = new File("a.txt");
        System.out.println(file.getAbsolutePath());

        File file1 = new File("W:\\JAVA\\maven_mybatis\\a.txt");
        System.out.println(file1.getAbsolutePath());
    }
}
