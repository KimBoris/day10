package org.example.fortune;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class FortuneServer {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5555);

        System.out.println("Ready.......");

        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getInetAddress());
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            //싱글톤에 익숙해지자
            String text = FortuneTeller.INSTANCE.getOne();

            dataOutputStream.writeUTF(text);
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
        }
    }
}
