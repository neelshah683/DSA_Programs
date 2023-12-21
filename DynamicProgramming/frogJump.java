package DynamicProgramming;

import java.util.Arrays;

public class frogJump {
    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(height, dp, n-1));
        System.out.println(frogJump2(height));
    }
    public static int frogJump(int[] height, int[] dp, int index)
    {
        if(index == 0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int right = Integer.MAX_VALUE;

        int left = frogJump(height, dp, index-1) + Math.abs(height[index] - height[index-1]);
        if(index > 1)
            right = frogJump(height, dp, index-2) + Math.abs(height[index] - height[index-2]);

        return dp[index] = Math.min(left, right);
    }
    public static int frogJump2(int[] heights)
    {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        for(int i=1; i<n; i++)
        {
            int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }
}
