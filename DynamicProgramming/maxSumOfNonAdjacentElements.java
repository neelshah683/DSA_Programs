package DynamicProgramming;

import java.util.Arrays;

public class maxSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(maxSum(nums, dp, n-1));
        System.out.println(maxSum2(nums, dp));
        System.out.println(maxSum3(nums, dp));

    }
    public static int maxSum(int[] nums, int[] dp, int index)
    {
        if(index == 0)
            return nums[index];
        if(index < 0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int pick = nums[index] + maxSum(nums, dp, index-2);

        int nonPick = 0 + maxSum(nums, dp, index-1);

        return dp[index] = Math.max(pick, nonPick);
    }
    public static int maxSum2(int[] nums, int[] dp)
    {
        int n = nums.length;
        dp[0] = nums[0];
        for(int i=1; i<n; i++)
        {
            int pick = nums[i];
            if(i > 1)
                pick+=dp[i-2];
            int nonPick = 0 + dp[i-1];

            dp[i] = Math.max(pick, nonPick);
        }
        return dp[n-1];
    }
    public static int maxSum3(int[] nums, int[] dp)
    {
        int n = nums.length;
        int prev = nums[0], prev2 = -1;
        for(int i=1; i<n; i++)
        {
            int pick= nums[i];
            if(i > 1)
                pick+=prev2;
            int nonPick = 0 + prev;
            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
    
}
