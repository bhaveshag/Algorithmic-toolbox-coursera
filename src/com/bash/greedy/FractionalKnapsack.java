package com.bash.greedy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        ItemValue[] iVal = new ItemValue[weights.length];
        for (int i = 0; i < weights.length; i++) {
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        //sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        Double totalValue = 0d;


        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;

            } else {
                // item cant be picked whole
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }
        totalValue = BigDecimal.valueOf(totalValue)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
        return totalValue;
    }


    // item value class
    static class ItemValue {
        Double cost;
        double wt, val, ind;

        // item value function
        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double(val / wt);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = 1;
        int capacity = 10;
        int[] values = {500};
        int[] weights = {30};

        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
