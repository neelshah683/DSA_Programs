package DynamicProgramming;

import java.util.Arrays;

public class minimumCoin {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int target = 4, n = nums.length;
        System.out.println(minCoin(n-1, nums, target));
        System.out.println(minCoin2(nums, target));
        System.out.println(minCoin3(nums, target));


    }
    public static int minCoin(int index, int[] nums, int target)
    {
        if(target == 0)
            return 0;
        if(index == 0)  
            if(target % nums[index] == 0)
                return target / nums[index];
            else
                return (int)1e9;

        int nonTake = minCoin(index-1, nums, target);
        int take = Integer.MAX_VALUE;
        if(target >= nums[index])
            take = 1 + minCoin(index, nums, target-nums[index]);
        
        return Math.min(nonTake, take);
    }
    public static int minCoin2(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        if(target == 0)
            dp[0][target] = 0;
        
        for(int i=1; i<=target; i++)
            if(i % nums[0] == 0)
                dp[0][i] = i / nums[0];
            else
                dp[0][i] = (int)1e9;
            
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=target; j++)
            {
                int nonTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(j >= nums[i])
                    take = 1 + dp[i][j-nums[i]];
                
                dp[i][j] = Math.min(nonTake, take);
            }
        }
        return dp[n-1][target];
    }
    public static int minCoin3(int[] nums, int target)
    {
        int n = nums.length;
        int[] prev = new int[target+1];
        
        int[] curr = new int[target+1];

        if(target == 0)
            prev[target] = 0;
        
        for(int i=1; i<=target; i++)
            if(i % nums[0] == 0)
                prev[i] = i / nums[0];
            else
                prev[i] = (int)1e9;
            
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=target; j++)
            {
                int nonTake = prev[j];
                int take = Integer.MAX_VALUE;
                if(j >= nums[i])
                    take = 1 + curr[j-nums[i]];
                
                curr[j] = Math.min(nonTake, take);
            }
            prev = curr;
        }
        return prev[target];
    }
}
