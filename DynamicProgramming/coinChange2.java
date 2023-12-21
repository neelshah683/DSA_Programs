package DynamicProgramming;

import java.util.Arrays;

public class coinChange2 {
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5, n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(coinChange(n-1, amount, dp, coins));
        System.out.println(coinChange_2(amount, coins));           
        System.out.println(coinChange_3(amount, coins));           


    }
    public static int coinChange(int index, int target, int[][] dp, int[] nums)
    {
        if(target == 0)
            return 1;
        if(index == 0)
            if(target % nums[index] == 0)
                return 1;
            else
                return 0;
        if(dp[index][target]!=-1)
            return dp[index][target];

        int nonPick = coinChange(index-1, target, dp, nums);
        int pick = 0;
        if(target >= nums[index])
            pick = coinChange(index, target-nums[index], dp, nums);

        return dp[index][target] = nonPick + pick;
    }   
    public static int coinChange_2(int target, int[] nums)
    {
        int n = nums.length;
       int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++)
            dp[i][0] = 1;

        for(int i=0; i<=target; i++)
            if(i % nums[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<=target; j++)
            {
                int nonPick = dp[i-1][j];
                int pick = 0;
                if(j >= nums[i])
                    pick = dp[i][j-nums[i]];

                dp[i][j] = nonPick + pick;
            }
        }
        return dp[n-1][target];
    } 
    public static int coinChange_3(int target, int[] nums)
    {
        int n = nums.length;
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int i=0; i<=target; i++)
            if(i % nums[0] == 0)
                prev[i] = 1;
            else
                prev[i] = 0;
        
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=target; j++)
            {
                int nonPick = prev[j];
                int pick = 0;
                if(j >= nums[i])
                    pick = curr[j-nums[i]];

                curr[j] = nonPick + pick;
            }
            prev = curr;
        }
        return prev[target];
    } 
}
