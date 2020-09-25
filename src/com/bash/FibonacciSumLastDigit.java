package com.bash;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {

        int f0 = 0;
        int f1 = 1;

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else {

            int rem = (int) (n % 60);

            if (rem == 0)
                return 0;

            for (int i = 2; i < rem + 3; i++) {
                int f = (f0 + f1) % 60;
                f0 = f1;
                f1 = f;
            }

            int s = f1 - 1;
            return s%10;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

