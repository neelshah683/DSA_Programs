package GreedyAlgorithms;

import java.util.*;

public class candy {
    public static void main(String[] args) {
        int[] ratings = {1, 3, 2, 0, 1, 4, 5, 4, 3};
        System.out.println(candy(ratings));
    }
    //TC: O(N) SC: O(1)
    public static int candy(int[] ratings) {
        if(ratings.length == 1) return 1;
        int len = ratings.length;
        int totalCandies = len;
        int indx = 1;
        while(indx < len){
            
            //Flat Surface or Equal
            if(indx < len && ratings[indx] == ratings[indx-1]){
                indx++;
                continue;
            }

            //Increasing Slope
            int peak = 0;
            while(indx < len && ratings[indx] > ratings[indx-1]){
                peak++;
                totalCandies += peak;
                indx++;
                if(indx == len)     return totalCandies;
            }

            //Decreasing Slope
            int valley = 0;
            while(indx < len && ratings[indx] < ratings[indx-1]){
                valley++;
                totalCandies += valley;
                indx++;
            }

            totalCandies -= Math.min(peak,valley);
        }
        return totalCandies;
    }
    //TC: O(N) SC: O(N)
    public static int candy2(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left , 1);
        Arrays.fill(right, 1);

        for(int indx = 1; indx < len; indx++){
            if(ratings[indx] > ratings[indx-1])
                left[indx] = left[indx-1] + 1;
        }

        for(int indx = len - 2; indx >= 0; indx--){
            if(ratings[indx] > ratings[indx + 1])
                right[indx] = right[indx + 1] + 1;
        }
        int maxCandies = 0;
        for(int indx = 0; indx < len; indx++){
            maxCandies += Math.max(left[indx], right[indx]);
        }
        return maxCandies;
    }
}
