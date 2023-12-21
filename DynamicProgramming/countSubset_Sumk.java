package DynamicProgramming;

import java.util.Arrays;

public class countSubset_Sumk {
    
    public static void main(String[] args) {
            
        int[] nums = {2, 3, 1, 2};
        int n = nums.length, target = 4;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp)
            Arrays.fill(row, 0);
        System.out.println(countSubset(nums, dp, n-1, target));
    }
    public static int countSubset(int[] nums, int[][] dp, int index, int k)
    {
        if(k == 0)
            return 1;
        if(index == 0)
            if(k == nums[index])
                return 1;
            else
                return 0;

        if(dp[index][k]!=0)
            return dp[index][k];

        int nonPick = countSubset(nums, dp, index-1, k);

        int pick = 0;
        if(k >= nums[index])
            pick = countSubset(nums, dp, index-1, k-nums[index]);

        return dp[index][k] = nonPick + pick;
    }
}
