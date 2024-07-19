package org.example.lotto;

import java.util.Scanner;

public class LottoUI {

    private Scanner scanner;

    public LottoUI() {
        scanner = new Scanner(System.in);
    }

    public int getAmount() {
        System.out.println("금액을 천원 단위로 적으세요");
        return scanner.nextInt();
    }


}
