package DynamicProgramming;

import java.util.Arrays;

public class bestTime_buySellStock_3 {

    public static void main(String[] args) {

        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int len = arr.length;
        int[][][] dp = new int[len + 1][2][3];
        for (int[][] row1 : dp)
            for (int[] row2 : row1)
                Arrays.fill(row2, -1);
        System.out.println(buySellStock_3(arr, 0, 1, 2, dp));
        System.out.println(buySellStock_3_2(arr));
        System.out.println(buySellStock_3_3(arr));
        int[][] dp2 = new int[len+1][4];
        for(int[] row: dp2)
            Arrays.fill(row, -1);
        System.out.println(buySellStock_4(arr, 0, 0, dp2));
    }

    public static int buySellStock_3(int[] nums, int index, int buy, int count, int[][][] dp) {
        if (index == nums.length || count == 0)
            return 0;
        if (dp[index][buy][count] != -1)
            return dp[index][buy][count];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-nums[index] + buySellStock_3(nums, index + 1, 0, count, dp),
                    buySellStock_3(nums, index + 1, 1, count, dp));
        } else {
            profit = Math.max(nums[index] + buySellStock_3(nums, index + 1, 1, count - 1, dp),
                    buySellStock_3(nums, index + 1, 0, count, dp));
        }
        return dp[index][buy][count] = profit;
    }

    public static int buySellStock_3_2(int[] nums) {
        int len = nums.length;
        int[][][] dp = new int[len + 1][2][3];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 1)
                        dp[i][j][k] = Math.max(-nums[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
                    else
                        dp[i][j][k] = Math.max(nums[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);

                }
            }
        }
        return dp[0][1][2];

    }
    public static int buySellStock_3_3(int[] nums) {
        int len = nums.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 1)
                        curr[j][k] = Math.max(-nums[i] + after[0][k], after[1][k]);
                    else
                        curr[j][k] = Math.max(nums[i] + after[1][k - 1], after[0][k]);

                }
            }
            after = curr;
        }
        return after[1][2];

    }
    public static int buySellStock_4(int[] nums, int index, int transaction, int[][] dp) {
        if (index == nums.length || transaction == 4)
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
}
