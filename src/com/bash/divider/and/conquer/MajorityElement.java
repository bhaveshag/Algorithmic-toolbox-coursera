package com.bash.divider.and.conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return 1;
        }
        if(a.length == 2){
            if(a[left] == a[right]) return 1;
            else
                return -1;
        }


        mergesort(a, left, right);
        int mid = (left + right) / 2;

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[mid])
                count++;
        }
        if (count > a.length/2){
            return 1;
        }

        return -1;
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
            if (n1[s1] < n2[s2]) {
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

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

