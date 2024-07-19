package org.example.fortune;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class FurtuneClient {
    //bad code
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 5555);
        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);

        String str = dis.readUTF();

        System.out.println(str);
    }
}
