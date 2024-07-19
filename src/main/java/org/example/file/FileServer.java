package org.example.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//bad code
public class FileServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready..................");

        Socket socket = serverSocket.accept();
        FileInputStream fis = new FileInputStream(new File("C:\\zzz\\M3.jpeg"));

        OutputStream os = socket.getOutputStream();

        byte[] buffer = new byte[1024 * 8];

        while(true)
        {
            int count = fis.read(buffer);
            if(count == -1) break;

            os.write(buffer, 0, count);


        }//end while

    }
}


