package org.example.str;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOut {
    //bad code
    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream(("Temp.txt"));
        DataOutputStream dos = new DataOutputStream(fos);//결합

        //dos.writeInt(1);
        //dos.writeInt(2);
        //dos.writeUTF("abc"); //구성정보 2바이트 + 알파벳 = 1바이트

        dos.writeUTF("홍길동");//구성정보 2바이트 +한글 1글자 = 3바이트
    }
}
