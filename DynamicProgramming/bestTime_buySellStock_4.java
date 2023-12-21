package DynamicProgramming;

import java.util.Arrays;

public class bestTime_buySellStock_4 {
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 0, 3};
        int len = arr.length, k = 2; 
        int[][] dp = new int[len+1][k*2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(buySellStock_4(arr, 0, 0, dp));
        System.out.println(buySellStock_4_2(arr, k));
        System.out.println(buySellStock_4_3(arr, k));

    }
    public static int buySellStock_4(int[] nums, int index, int transaction, int[][] dp) {
        if (index == nums.length || transaction == dp[0].length)
            return 0;
        if (dp[index][transaction] != -1)
            return dp[index][transaction];

        int profit = 0;
        if (transaction % 2 == 0 ) {
            profit = Math.max(-nums[index] + buySellStock_4(nums, index + 1, transaction+1, dp),
                    buySellStock_4(nums, index + 1, transaction, dp));
        } else {
            profit = Math.max(nums[index] + buySellStock_4(nums, index + 1, transaction+1, dp),
                    buySellStock_4(nums, index + 1, transaction, dp));
        }
        return dp[index][transaction] = profit;
    }
    public static int buySellStock_4_2(int[] nums, int k)
    {
        int len = nums.length, col = k*2;
        int[][] dp = new int[len+1][col+1];

        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<col; j++)
            {
                if(j % 2 == 0)
                    dp[i][j] = Math.max(-nums[i] + dp[i+1][j+1], dp[i+1][j]);
                else
                    dp[i][j] = Math.max(nums[i] + dp[i+1][j+1], dp[i+1][j]);   
            }
        }
        return dp[0][0];
    }
    public static int buySellStock_4_3(int[] nums, int k)
    {
        int len = nums.length, col = k*2;
        int[] prev = new int[col+1];
        int[] curr = new int[col+1];

        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<col; j++)
            {
                if(j % 2 == 0)
                    curr[j] = Math.max(-nums[i] + prev[j+1], prev[j]);
                else
                    curr[j] = Math.max(nums[i] + prev[j+1], prev[j]);   
            }
            prev = curr;
        }
        return prev[0];
    }
}
