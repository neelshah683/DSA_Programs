package DynamicProgramming.partitionDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class minCostCutStick {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5};
        int[] arr = new int[nums.length+2];
        int len = nums.length,n=7;
        for(int i=0; i<len; i++)
            arr[i+1]=nums[i];
        arr[arr.length-1] = n;
        // Arrays.sort(arr);
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(minCost(dp, arr, 1, len));
        System.out.println(minCost2(arr, len));

    }
    public static int minCost(int[][] dp, int[] nums, int i, int j)
    {
        if(i > j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int index=i; index<=j; index++)
        {
            int cost = nums[j+1]-nums[i-1] + minCost(dp, nums, i, index-1) + minCost(dp, nums, index+1, j);
            mini = Math.min(mini, cost); 
        }
        return dp[i][j] = mini;
    }
    public static int minCost2(int[] nums, int len)
    {
        int len2 = nums.length;
        int[][] dp = new int[len2][len2];
        
        for(int i=len; i>=1; i--)
        {
            for(int j=1; j<=len; j++)
            {
                if(i>j)
                    continue;
                int mini = Integer.MAX_VALUE;
                for(int index=i; index<=j; index++)
                {
                    int cost = nums[j+1]-nums[i-1] + dp[i][index-1] + dp[index+1][j];
                    mini = Math.min(mini, cost); 
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][len];        
    }
}
