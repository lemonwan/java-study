package cn.xinongbest.server;
/**
 * 网络通信三要素：IP地址、协议和端口
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3307);
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    // 字节流转换为字符流
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // 字符流转换为带缓冲的字符流，方便按行读取 | 读取首行
                    String s = br.readLine();
                    if (s != null) {
                        System.out.println("访问的资源是：" + s);
                        String[] s1 = s.split(" ");
                        // 获取网络输出流对象
                        OutputStream os = socket.getOutputStream();
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        if (s1[1].endsWith("jpg") || s1[1].endsWith("png")) {
                            os.write("Content-Type:image/png\r\n".getBytes());
                        } else {
                            os.write("Content-Type:text/html\r\n".getBytes());
                        }
                        // HTTP头有一个空行
                        os.write("\r\n".getBytes());
                        // 启动本地输入流
                        FileInputStream fis = new FileInputStream(s1[1].substring(1));
                        int len;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0 , len);
                        }
                        socket.shutdownOutput();
                        os.close();
                        fis.close();
                        br.close();
                    } else {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
