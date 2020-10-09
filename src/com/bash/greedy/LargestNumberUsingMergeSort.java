package com.bash.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumberUsingMergeSort {

    public static String largestNumber(int[] nums) {
        // when all the numbers are 0 then return single 0
        if (!Arrays.stream(nums).anyMatch(num -> num != 0)) {
            return "0";
        }
        mergesort(nums, 0 , nums.length-1);

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println("nums[i] " + nums[i]);
//        }
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }

    private static void mergesort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergesort(a, left, mid);
        mergesort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int l, int m, int r) {
        int[] n1 = Arrays.copyOfRange(a, l, m + 1);
        int[] n2 = Arrays.copyOfRange(a, m + 1, r + 1);

        int s1 = 0;
        int s2 = 0;
        int aI = l;

        while (s1 < n1.length && s2 < n2.length) {
            if (compare(n1[s1], n2[s2]) >= 0) {
                a[aI++] = n1[s1];
                s1++;
            } else {
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
    }

    private static int compare(int a, int b){
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        return (as+bs).compareTo(bs+as);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] a = {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
//        int[] a = {10,2};
        int[] a = {3,30,34,5,9};

        System.out.println(largestNumber(a));
    }
}

