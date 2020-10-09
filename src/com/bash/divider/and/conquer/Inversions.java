package com.bash.divider.and.conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        return mergesort(a, left, right);
    }

    private static int mergesort(int[] a, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int inv1 = mergesort(a, left, mid);
        int inv2 = mergesort(a, mid + 1, right);
        int merge = merge(a, left, mid, right);
        return merge + inv1 + inv2;
    }

    private static int merge(int[] a, int l, int m, int r) {
        int[] n1 = Arrays.copyOfRange(a, l, m + 1);
        int[] n2 = Arrays.copyOfRange(a, m + 1, r + 1);
        int count = 0;
        int s1 = 0;
        int s2 = 0;
        int aI = l;

        while (s1 < n1.length && s2 < n2.length) {
            if (n1[s1] <= n2[s2]) {
                a[aI++] = n1[s1];
                s1++;
            } else {
                count = count + (n1.length - s1);
                a[aI++] = n2[s2];
                s2++;
            }
        }


        while (s1 < n1.length) {

            a[aI++] = n1[s1];
            s1++;
        }

        while (s2 < n2.length) {
            a[aI++] = n2[s2];
            s2++;
        }
        //System.out.println("count = " + count);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
    }
}

