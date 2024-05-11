package com.boot.banking.util;

import java.util.Random;

public class BankUtils {
    public static String generateAccountNumber() {
        // Generating a random 8-digit account number
        Random random = new Random();
        int number = random.nextInt(90000000) + 10000000;
        return String.valueOf(number);
    }
}
