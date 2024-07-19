package org.example.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileClient {

    public static void main(String[] args) throws Exception {

        //연결
        try (Socket socket = new Socket("127.0.0.1", 5555);
             //빨대 (확장자는 맞춰줘야한다.)
             InputStream is = socket.getInputStream();
             FileOutputStream fos = new FileOutputStream("copy.jpeg");
        ) {//파일 저장
            byte[] buffer = new byte[100];

            while (true) {
                //1바이트씩 읽어보자
                int data = is.read();
                if (data == -1) break;
                fos.write(buffer, 0, data);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}