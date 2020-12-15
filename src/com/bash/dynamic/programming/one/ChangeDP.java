package com.bash.dynamic.programming.one;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int temp[]=new int[m+1];
        int coins[] = {1,3,4};

        temp[0] = 0;

        for(int i=0; i<3; i++)
            for(int j=coins[i]; j<=m; j++) {
                temp[j] = Math.min(temp[j - coins[i]]+1 , temp[j]==0?99999999:temp[j]) ;
            }
        return temp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

