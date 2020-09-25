package com.bash.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestNumberNumberInput {
    private static String largestNumber(int[] nums) {
        if(!Arrays.stream(nums).anyMatch(num -> num !=0)){
            return "0";
        }
        String[] a = Arrays.stream(nums)
                .mapToObj(value -> Integer.toString(value))
                .toArray(String[]::new);


        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1)>=0 ? -1 :1;
            }
        });



        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] " + a[i]);
        }
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {824,938,1399,5607,6973,5703,9609,4398,8247};

        System.out.println(largestNumber(a));
    }
}

