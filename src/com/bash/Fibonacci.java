package com.bash;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    long[] arr = new long[n+1];
    if (n <= 1)
      return n;
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 1;
    for (int i = 3; i < n+1; i++) {
      arr[i] = arr[i-1] + arr[i-2];
    }

    return arr[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
