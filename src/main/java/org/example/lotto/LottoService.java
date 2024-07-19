package org.example.lotto;

import java.util.*;

public class LottoService {

    public List<LottoUI> generateLottoNumbers()
    {
        List<LottoUI> balls = new ArrayList<>();
        for(int i = 0; i<= 45; i++)
        {
            balls.add(new LottoUI());
        }
        Collections.shuffle(balls, new Random());
        return balls.subList(0,6);
    }

    public String getLottoTickets(int numTickets)
    {
        StringBuilder result = new StringBuilder();
        for(int i =0; i< numTickets; i++)
        {
            List<LottoUI> ticket = generateLottoNumbers();
            result.append("Ticket").append(i+1).append(": ").append(ticket).append("\n");
        }
        return result.toString();
    }



}
