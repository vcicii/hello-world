import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(7832);//Socket的服务器 并且指定端口号

        System.out.println("服务器开启监听！");
        //服务器开始监听
        Socket socket=server.accept();//服务器开始监听    阻塞

        InputStream ins=socket.getInputStream();//返回此套接字的输入流。
        OutputStream ous=socket.getOutputStream();//返回此套接字的输出流。

        BufferedReader br=new BufferedReader(new InputStreamReader(ins));//将客户端那边的信息 放入缓存流
        PrintWriter pw=new PrintWriter(ous,true);//通过Socket自带的流将数据  输出到客户端

        Scanner input=new Scanner(System.in);
        String str=null;
        while (true){    //让客户端和服务器一直发送消息
            System.out.println(br.readLine());//输出客户端的信息
            str=input.nextLine();
            pw.println("女朋友："+str);  //将信息输出到客户端
        }
    }
}