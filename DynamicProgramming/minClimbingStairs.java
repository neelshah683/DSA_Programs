package DynamicProgramming;

import java.util.Arrays;

public class minClimbingStairs {
    
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int n = cost.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // int index = 0;
        // if(cost[n-2] > cost[n-1])
        //     index = n-1;
        // else
        //     index = n-2;

        int left = minCost(cost, dp, n-1);
        int right = minCost(cost, dp, n-2);
        System.out.println(Math.min(left, right));
        System.out.println(minCost2(cost));

    }
    public static int minCost(int[] cost, int[] dp, int index)
    {
        if(index == 0)
            return cost[index];
        if(index < 0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int left = cost[index] + minCost(cost, dp, index-1);
        int right = cost[index] + minCost(cost, dp, index-2);

        return dp[index] = Math.min(left, right);
    }
    public static int minCost2(int[] cost)
    {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        
        for(int i=1; i<n ;i++)
        {
            int left = cost[i] + dp[i-1];
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = cost[i] + dp[i-2];
            else
                right = cost[i] + 0;

            dp[i] = Math.min(left, right);
        }
        return Math.min(dp[n-2], dp[n-1]);
    }
}
