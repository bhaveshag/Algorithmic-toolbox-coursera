package com.bash.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int lenO1 = o1.length();
                int lenO2 = o2.length();
                int minLength = Math.min(lenO1, lenO2);
                int i = 0, j = 0;
                while (true) {

                    //System.out.println("i " + i + " and o1[i] " + o1.charAt(i));
                    //System.out.println("i " + j + " and o2[j] " + o2.charAt(j));
                    if (o1.charAt(i) == o2.charAt(j)) {
                        if (i == lenO1 - 1 && j == lenO2 - 1) {
                            return 0;
                        }
                    } else {
                        if (o1.charAt(i) < o2.charAt(j)) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                    if (i < lenO1 - 1) {
                        i++;
                    }
                    if (j < lenO2 - 1) {
                        j++;
                    }
                }
            }
        });


//        for (int i = 0; i < a.length; i++) {
//            System.out.println("a[i] " + a[i]);
//        }
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

