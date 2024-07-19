package org.example.lotto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LottoServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Ready.............");

        LottoService lottoService = new LottoService();

        while (true)
            try (Socket socket = serverSocket.accept();
                 OutputStream out = socket.getOutputStream();
                 Scanner scanner = new Scanner(socket.getChannel())) {

                String line = scanner.nextLine();
                System.out.println(line);
                String[] words = line.split(" ");
                if(words.length<2|| words[1].startsWith("/facivon.ico"))
                {
                    continue;
                }
                String path = words[1];
                String[] pathParts = path.split("=");
                if(pathParts.length<2)
                {
                    continue;
                }
                int price = Integer.parseInt(pathParts[1]);
                int numTickets = price/1000;
                String response = lottoService.getLottoTickets(numTickets);

                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("Content-Type: text/plain\r\n\r\n".getBytes());
                out.write(response.getBytes());

            }
    }


}
