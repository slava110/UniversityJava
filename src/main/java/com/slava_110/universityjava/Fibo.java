package com.slava_110.universityjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int start = readInt(input, "first number index", 0, Integer.MAX_VALUE);

        int amount = readInt(input, "amount of numbers", 1, Integer.MAX_VALUE);

        getFiboNums(start, amount).forEach(num -> {
            System.out.printf("> %s\n", num);
        });
    }

    /**
     * Get fibonnachi numbers
     * @param start first number index
     * @param amount amount of numbers
     * @return list of numbers
     */
    public static List<Long> getFiboNums(int start, int amount) {
        List<Long> res = new ArrayList<>();

        int end = start + amount;

        long prev = 0;
        long cur = 1;

        for(int num = 0; num < end; num++) {
            if(num >= start)
                res.add(prev);

            long sum = prev + cur;
            prev = cur;
            cur = sum;
        }

        return res;
    }

    /**
     * Print formatted message to console and wait for next int in specified range
     * @param scanner inputstream scanner
     * @param message what use should enter
     * @param min minimum value
     * @param max maximum value
     * @return user input
     */
    private static int readInt(Scanner scanner, String message, int min, int max) {
        System.out.printf("Enter %s (integer between %s and %s)\n", message, min, max);
        int res;
        while(true) {
            res = scanner.nextInt();
            if(res < min)
                System.out.printf("Number is too low! Enter number between %s and %s\n", min, max);
            else if(res > max) {
                System.out.printf("Number is too high! Enter number between %s and %s\n", min, max);
            } else
                break;
        }
        return res;
    }
}
