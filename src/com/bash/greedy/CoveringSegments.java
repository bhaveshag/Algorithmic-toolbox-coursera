package com.bash.greedy;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return o1.end < o2.end ? -1 : 1;
            }
        });

//        for (int i = 0; i < segments.length; i++) {
//            System.out.println("segments []" + segments[i].start + ", " + segments[i].end);
//        }
        int end = segments[0].end;
        //System.out.println("End "+ end);
        int[] out = new int[segments.length];
        int j = 0;
        for (int i = 1; i < segments.length; i++) {
            if (segments[i].start > end) {
                out[j++] = end;
                end = segments[i].end;
            }
        }
        out[j++] = end;
        return Arrays.copyOfRange(out, 0, j);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        Segment[] segments = new Segment[n];
        segments[0] = new Segment(1,3);
        segments[1] =  new Segment(2,5);
        segments[2] =  new Segment(3,6);
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
 
