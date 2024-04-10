package GreedyAlgorithms;

import java.util.*;

public class insertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals,newInterval)));
    }
    //TC: O(N) SC: O(1)
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        for(int indx = 0; indx < len; indx++){

            //if not overlapping
            if(newInterval[0] > intervals[indx][1])
                ans.add(intervals[indx]);

            //remaining slot insertion    
            else if(newInterval[1] < intervals[indx][0]){
                ans.add(newInterval);
                newInterval = intervals[indx];
            }
            //merge overlapping intervals
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[indx][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[indx][1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
