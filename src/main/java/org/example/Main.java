package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    //bad code
    public static void main(String[] args) throws Exception {

        FileInputStream fin = new FileInputStream("aaa.jpg");
        FileOutputStream fout = new FileOutputStream("copy.jpg");



        //계란바구니 buffer
        byte[] buffer = new byte[1024*8]; //1kb

        long start = System.currentTimeMillis();
        //System.out.println("타임 : "+start);

        //몇번이나 읽어야 하는지 모른다
        while (true) {
            //몇개나 새로운 데이터를 읽어 냈느냐
            int count = fin.read(buffer);

            System.out.println(count);

            //끝까지 읽으면 -1
            if (count == -1)
                break;

            //새로 버퍼를 채운만큼만
            fout.write(buffer, 0, count);

        }//end while

        long end = System.currentTimeMillis();
        System.out.println("Time = "+(end - start));
    }
}