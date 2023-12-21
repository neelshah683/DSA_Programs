package DynamicProgramming;

import java.util.Arrays;

public class partitionEqualSubsetSum {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int sum = 0, n = nums.length, k = 3;

        for(int i : nums)
            sum+=i;

        int target = sum/k;

        if(sum%k != 0)
            System.out.println(false);
        else
        {
        int[][] dp = new int[n][target+1];
        for(int[] row: dp)
            Arrays.fill(row, -1); 
            if(subsetSum(nums, dp, n-1, target-1) == k)
                System.out.println(true);
            else
                System.out.println(false);
        }

    }
    public static int subsetSum(int[] nums, int[][] dp, int index, int k)
    {
        if(k == 0)
            return 1;
            
        if(index == 0)
            if(k == nums[index])
                return 1;
            else
                return 0;

        if(dp[index][k]!=-1)
            return 0;

        int nonPick = subsetSum(nums, dp, index-1, k);

        int pick = 0;
        if(k >= nums[index])
            pick = subsetSum(nums, dp, index-1, k-nums[index]);
        
                

        return dp[index][k] = nonPick + pick;
    }
}
