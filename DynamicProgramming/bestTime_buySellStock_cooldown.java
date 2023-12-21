package DynamicProgramming;

import java.util.Arrays;

public class bestTime_buySellStock_cooldown {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int len = prices.length;
        int[][] dp = new int[len+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(buySellStock_CD(0, 1, prices, dp));
        System.out.println(buySellStock_CD_2(prices));

    }
    public static int buySellStock_CD(int index, int buy, int[] nums, int[][] dp)
    {
        if(index >= nums.length)
            return 0;
        if(dp[index][buy]!=-1)
            return dp[index][buy];

        int profit1 = 0; 
        if(buy==1)
            profit1 = Math.max(-nums[index] + buySellStock_CD(index+1, 0, nums, dp),buySellStock_CD(index+1, 1, nums, dp));
        else
            profit1 = Math.max(nums[index] + buySellStock_CD(index+2, 1, nums, dp) ,buySellStock_CD(index+1, 0, nums, dp));
        return dp[index][buy] = profit1;
    }
    public static int buySellStock_CD_2(int[] nums)
    {
        int len = nums.length;
        int[][] dp = new int[len+2][2];

        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<2; j++)
            {
                if(j==1)
                    dp[i][j]= Math.max(-nums[i] + dp[i+1][0], dp[i+1][1]);
                else
                    dp[i][j]= Math.max(nums[i] + dp[i+2][1] ,dp[i+1][0]);
            }
        }
        return dp[0][1];
    }
   
}
