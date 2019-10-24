import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class ChatClient {
    public static void main(String[] args) throws IOException {
        // 指定服务器的IP地址     端口号
        Socket socket=new Socket("localhost",7832);

        InputStream is=socket.getInputStream();//得到Socket自带的输入流
        OutputStream os=socket.getOutputStream();//得到Socket自带的输出流

        BufferedReader br=new BufferedReader(new InputStreamReader(is));//将输入流 放入 缓存中
        PrintWriter pw=new PrintWriter(os,true);//通过输出流   向服务器发消息

        Scanner input=new Scanner(System.in);
        String str=null;

        while (true){
            str=input.nextLine();
            pw.println(str);//发消息
            System.out.println(br.readLine());//收消息
        }
    }
}