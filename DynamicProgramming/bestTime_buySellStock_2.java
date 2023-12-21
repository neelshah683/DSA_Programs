package DynamicProgramming;

import java.util.Arrays;

public class bestTime_buySellStock_2 {
    
    public static void main(String[] args) {
        int[] nums = {4, 9, 0, 4, 10};
        int len =nums.length, profit = 0;
        for(int i=1; i<len; i++)
        {
            if(nums[i] > nums[i-1])
                profit+= nums[i]-nums[i-1];
        }
        System.out.println(profit);

        int[][] dp = new int[len+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(buySellStock2(0, 1, nums, dp));
        System.out.println(buySellStock2_2(nums));

    }
    public static int buySellStock2(int index, int buy, int[] nums, int[][] dp)
    {
        if(index == nums.length)
            return 0;
        if(dp[index][buy]!=-1)
            return dp[index][buy];

        int profit1 = 0; 
        if(buy==1)
            profit1 = Math.max(-nums[index] + buySellStock2(index+1, 0, nums, dp),buySellStock2(index+1, 1, nums, dp));
        else
            profit1 = Math.max(nums[index] + buySellStock2(index+1, 1, nums, dp) ,buySellStock2(index+1, 0, nums, dp));
        return dp[index][buy] = profit1;
    }
    public static int buySellStock2_2(int[] nums)
    {
        int len = nums.length;
        int[][] dp = new int[len+1][2];
        dp[len][0] = dp[len][1] = 0;

        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<2; j++)
            {
                if(j==1)
                    dp[i][j]= Math.max(-nums[i] + dp[i+1][0], dp[i+1][1]);
                else
                    dp[i][j]= Math.max(nums[i] + dp[i+1][1] ,dp[i+1][0]);
            }
        }
        return dp[0][1];
    }
}
