package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//bad code
public class Server1 {
    public static void main(String[] args) throws Exception {


        //서버소켓 5555
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready......................");

        //byte[] 내용물 담기용
        // byte[] buffer = new byte[1024 * 8];

        while (true) {
            //연결 accept
            try (
                    Socket socket = serverSocket.accept();
                    OutputStream out = socket.getOutputStream();
                    FileInputStream fin = new FileInputStream("aaa.jpg");
            ) {
                out.write((new String("HTTP/1.1 200 OK\r\n").getBytes()));
                out.write(new String("Cache-Control: private\r\n").getBytes());
                out.write(new String("Content-Type: image/pdf\r\n\r\n").getBytes());

                byte[] buffer = new byte[1024 * 8];
                while (true) {
                    //몇개나 새로운 데이터를 읽어 냈느냐
                    int count = fin.read(buffer);

                    System.out.println(count);

                    //끝까지 읽으면 -1
                    if (count == -1)
                        break;

                    //새로 버퍼를 채운만큼만
                    out.write(buffer, 0, count);

                }   } catch (Exception e) {
                e.printStackTrace();
            }


              //  out.write(msg.getBytes(StandardCharsets.UTF_8));

            /*
            //inputStream -> read(byte[])
            InputStream in = serverSocket.accept().getInputStream();
            int len = in.read(buffer);

            System.out.println(new String(buffer, 0, len));
*/
        }
    }
}
