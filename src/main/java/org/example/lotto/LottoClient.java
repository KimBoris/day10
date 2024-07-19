package org.example.lotto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class LottoClient {

    public static void main(String[] args) throws Exception {
        LottoUI lottoUI = new LottoUI();

        while (true) {
            int amount = lottoUI.getAmount();
            if (amount % 1000 != 0) {
                System.out.println("금액을 천원단위로 입력해주세요");
                continue;
            }
            try (Socket socket = new Socket("127.0.0.1", 5555);
                 OutputStream out = socket.getOutputStream();
                 DataInputStream in = new DataInputStream(socket.getInputStream())) {

                String request = "GET /lotto?money=" + amount + "HTTP/1.1\r\nHost : 127.0.0.1\r\n\r\n";
                out.write(request.getBytes());

                Scanner scanner = new Scanner(in);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }


        }

    }
}
