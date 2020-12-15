package com.bash.dynamic.programming.one;

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
         List<Integer> min_steps = new ArrayList<>();
        List<Integer> predecessor = new ArrayList<>();

        for (int i = 0; i <= n+1; i++) {
            min_steps.add(0);
            predecessor.add(0);
        }

        for (int i = 2; i <= n; i++)
        {
            min_steps.set(i, min_steps.get(i-1) + 1);
            predecessor.set(i, i - 1);
            if (i % 3 == 0)
                if (min_steps.get(i/3) < min_steps.get(i))
                {
                    min_steps.set(i, min_steps.get(i/3) + 1);
                    predecessor.set(i, i/3);
                }
            if (i % 2 == 0)
                if (min_steps.get(i/2) < min_steps.get(i))
                {
                    min_steps.set(i, min_steps.get(i/2) + 1);
                    predecessor.set(i, i/2);
                }
        }

        List<Integer> sequence = new ArrayList<>();
        for (int i = n; i != 0; i = predecessor.get(i)) {
            sequence.add(i);
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

