package DynamicProgramming;

import java.util.Arrays;

public class maxLenGoodSubsequence {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3};
        int k = 2;
        System.out.println(maximumLength(nums, k));
        System.out.println(maximumLength2(nums, k));
        System.out.println(maximumLength3(nums, k));

    }
    //Memoization | TC: | SC: 
    public static int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if(n == 1)  return 1;

        int[][][] dp = new int[n+1][n+1][k+1];
        for(int[][] row1 : dp){
            for(int[] row2 : row1){
                Arrays.fill(row2, -1);
            }
        }
        return solve(nums, 0, -1, k, dp);
    }
    public static int solve(int[] nums, int indx, int prev, int k, int[][][] dp){
        if(indx >= nums.length) return 0;
        if(dp[indx][prev+1][k] != -1)
                return dp[indx][prev+1][k];

        int take = 0;
        if(prev == -1 || nums[indx] == nums[prev])
            take = 1 + solve(nums, indx+1, indx, k, dp);
        else if(k > 0)
            take = 1 + solve(nums, indx + 1, indx, k-1, dp);

        int nonTake = solve(nums, indx + 1, prev, k, dp);

        return dp[indx][prev+1][k] = Math.max(nonTake, take);
    }
    public static int maximumLength2(int[] nums, int k){
        int n = nums.length;
        int[][][] dp = new int[n+1][n+1][k+1];
        for(int indx1 = n-1; indx1 >= 0; indx1--)
        {
            for(int indx3 = indx1-1; indx3 >= -1; indx3--){
                
                for(int indx2 = k; indx2 >= 0; indx2--){

                    int take = 0;
                    if(indx3 == -1 || nums[indx1] == nums[indx3])
                        take = 1 + dp[indx1+1][indx1+1][indx2];
                    else if(indx2 > 0)
                        take = 1 + dp[indx1 + 1][indx1+1][indx2-1];

                    int nonTake = dp[indx1 + 1][indx3+1][indx2];

                    dp[indx1][indx3+1][indx2] = Math.max(nonTake, take);
                }
            }
        }
        return dp[0][0][k];
    }
    public static int maximumLength3(int[] nums, int k){
        int n = nums.length;
        int[][] dp = new int [n+1][k+1];

        for(int indx1 = n-1; indx1 >= 0; indx1--)
        {
            int[][] newDp = new int [n+1][k+1];

            for(int indx3 = indx1-1; indx3 >= -1; indx3--){
                
                for(int indx2 = k; indx2 >= 0; indx2--){

                    int take = 0;
                    if(indx3 == -1 || nums[indx1] == nums[indx3])
                        take = 1 + dp[indx1+1][indx2];
                    else if(indx2 > 0)
                        take = 1 + dp[indx1+1][indx2-1];

                    int nonTake = dp[indx3+1][indx2];

                    newDp[indx3+1][indx2] = Math.max(nonTake, take);
                }
            }
            dp = newDp;
        }
        return dp[0][k];
    }
}
