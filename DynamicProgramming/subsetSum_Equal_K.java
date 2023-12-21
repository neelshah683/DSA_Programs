package DynamicProgramming;

import java.util.Arrays;

public class subsetSum_Equal_K {
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1};
        int target = 4;
        int[][] dp = new int[nums.length][target+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(subsetSum(nums, dp, nums.length-1, target));
        System.out.println(subsetSum2(nums, nums.length, target));
        System.out.println(subsetSum3(nums, nums.length, target));

    }
    public static boolean subsetSum(int[] nums, int[][] dp, int index, int target)
    {
        if(target == 0)
            return true;
        if(index == 0)
            return nums[index] == target;
        if(dp[index][target]!=-1)
            return dp[index][target]==0?false : true;

        boolean nonTake = subsetSum(nums, dp, index-1, target);

        boolean take = false;
        if(target >= nums[index])
            take = subsetSum(nums, dp, index-1, target-nums[index]);     

        dp[index][target] = nonTake || take ? 1 : 0;
        return nonTake || take;
    }
    public static boolean subsetSum2(int[] nums, int n, int k)
    {
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++)
            dp[i][0] = true;
        
        if(nums[0] <= k)
            dp[0][nums[0]] = true;
        
        for(int i=1; i<n; i++)
        {
            for(int j=1; j<=k; j++)
            {
                boolean nonTake = dp[i-1][j];

                boolean take = false;
                if(j >= nums[i])
                    take = dp[i-1][j-nums[i]];

                dp[i][j] = nonTake || take ;
            }
        }
        return dp[n-1][k];
    }
    public static boolean subsetSum3(int[] nums, int n, int k)
    {
        boolean[] prev = new boolean[k+1];

        prev[0] =  true;
        
        if(nums[0] <= k)
            prev[nums[0]] = true;
        
        for(int i=1; i<n; i++)
        {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int j=1; j<=k; j++)
            {
                boolean nonTake = prev[j];

                boolean take = false;
                if(j >= nums[i])
                    take = prev[j-nums[i]];

                curr[j] = nonTake || take ;
            }
            prev = curr;
        }
        return prev[k];
    }
}
