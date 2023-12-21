package DynamicProgramming;

import java.util.Arrays;

public class Robber2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 5};
        int n = nums.length;
        int[] nums2 = new int[n-1];
        int[] nums3 = new int[n-1];
        for(int i=0; i<n-1; i++)
        {
            nums2[i] = nums[i];
            nums3[i] = nums[i+1];
        }

        int[] dp1 = new int[nums2.length+1];
        int[] dp2 = new int[nums3.length+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        System.out.println(Math.max(maxSum(nums2, dp1, nums2.length-1), maxSum(nums3, dp2, nums3.length-1)));
        // System.out.println(maxSum2(nums, dp));
        // System.out.println(maxSum3(nums, dp));

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
