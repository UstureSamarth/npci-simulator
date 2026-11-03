package com.sarvatra.sim.util;

import com.sarvatra.sim.npci.xml.pojo.common.resp.bal.MiniStatement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StmtGenerator {

    public static final SecureRandom RANDOM = new SecureRandom();

    public static List<MiniStatement.StmtData> generateStmtData(int count) {
        List<MiniStatement.StmtData> list = new ArrayList<>();

        double balance = 0.0;

        for (int i = 1; i <= count; i++) {

            String date = getRandomDate();
            String type = RANDOM.nextBoolean() ? "D" : "W";
            String ref = getRandomRef();
            double amount = getRandomAmount();

            String sign;
            if ("D".equals(type)) {
                sign = "C";
                balance += amount;
            } else {
                sign = "D";
                balance -= amount;
            }

            String value = String.format("%s POS/%s/%s %s%.2f",
                    date, type, ref, sign, amount);

            list.add(MiniStatement.StmtData.of(String.valueOf(i), value));
        }

        String balanceStr = String.format("Balance:%+.2f", balance);
        list.add(MiniStatement.StmtData.of(String.valueOf(count + 1), balanceStr));

        return list;
    }

    private static String getRandomDate() {
        int day = 1 + RANDOM.nextInt(28);
        int month = 1 + RANDOM.nextInt(12);
        return String.format("%02d/%02d", day, month);
    }

    private static String getRandomRef() {
        if (RANDOM.nextInt(5) == 0) {
            return "NFTRF/" + (1000 + RANDOM.nextInt(9000));
        }
        return String.valueOf(5016000000L + RANDOM.nextInt(10000));
    }

    private static double getRandomAmount() {
        return 100 + (900 * RANDOM.nextDouble());
    }
}
