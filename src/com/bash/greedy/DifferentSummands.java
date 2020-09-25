package com.bash.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        int i = 1;
        while (true) {
            if (n - 2 * i <= 0) {
                break;
            }
            summands.add(i);
            n = n - i;
            i++;

        }
        summands.add(n);
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

