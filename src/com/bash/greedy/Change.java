package com.bash.greedy;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int sum = 0;
        // 10 rs coins
        sum = sum + m/10;
        m= m%10;
        sum = sum + m/5;
        m = m%5;
        sum = sum +m;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

