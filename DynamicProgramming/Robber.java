package DynamicProgramming;

import java.util.Arrays;

public class Robber {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(maxAmount(nums, dp, n-1));
        System.out.println(maxAmount2(nums, dp));

    }
    public static int maxAmount(int[] nums, int[] dp, int index)
    {
        if(index == 0)
            return nums[index];
        if(index < 0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int pick = nums[index] + maxAmount(nums, dp, index-2);

        int nonPick = 0 + maxAmount(nums, dp, index-1);

        return dp[index] = Math.max(pick, nonPick);
    }
    public static int maxAmount2(int[] nums, int[] dp)
    {
        int prev = nums[0], prev2 = -1, n = nums.length;
        for(int i=1; i<n; i++)
        {
            int pick = nums[i];
            if(i>1)
                pick+=prev2;
            int nonPick = 0 + prev;

            int curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
