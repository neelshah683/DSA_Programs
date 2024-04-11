package GreedyAlgorithms;

import java.util.*;

public class nonOverlappingIntervals {
    
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 100},
            {2, 12},
            {11, 22},
            {1, 11}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[1] - b[1]));

        int cntRemoval = 0;
        int len = intervals.length;

        int endTime = intervals[0][1];

        for(int indx = 1; indx < len; indx++){
            if(intervals[indx][0] >= endTime){
                endTime = intervals[indx][1];
            }
            else{
                cntRemoval++;
            }
        }
        return cntRemoval;
    }
}
