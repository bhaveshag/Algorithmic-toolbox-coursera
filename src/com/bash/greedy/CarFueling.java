package com.bash.greedy;

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {

        int minrefills = 0;
        int currStop = 0;
        int lastStop = 0;

        if(tank >= dist){
            return 0;
        }

        if(tank < stops[0]){
            return -1;
        }

        // Searching for maximum reachable first stop
        while(currStop < stops.length && stops[currStop] <= tank){
            currStop++;
        }
        lastStop = currStop-1;
        minrefills++;

        while(currStop < stops.length){

            // Check if next stop is not reachable
            if(stops[currStop] - stops[lastStop] > tank){
                if(lastStop + 1 == currStop){
                    return -1;
                }else{
                    lastStop = currStop-1;
                    minrefills++;
                    if(stops[currStop] - stops[lastStop] > tank){
                        return -1;
                    }
                }
            }
            currStop++;
        }
        System.out.println("minrefills " + minrefills);
        System.out.println("currStop " + currStop);
        System.out.println("lastStop " + lastStop);

        if(stops[lastStop] + tank >= dist){
            return  minrefills;
        }

        if(lastStop != currStop-1 && stops[currStop-1] - stops[lastStop] <= tank){
            lastStop = currStop-1;
            minrefills++;
        }
        // last remaining stop
        System.out.println("lastStop " + lastStop);
        if(stops[lastStop] + tank < dist){
            return -1;
        }

        return minrefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = 250;
        int tank = 250;
        int stops[] = {100,150};

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
