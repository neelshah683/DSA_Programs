package DynamicProgramming.partitionDp;

import java.util.Arrays;

public class burstBalloons {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        int len = arr.length;
        int[] nums = new int[len+2];
        for (int i=0 ;i<len;++i){
            nums[i+1]=arr[i];
        }
        nums[0]=1;
        nums[nums.length-1]=1;
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(maxCoins(dp, nums, 1, len));
        System.out.println(maxCoins2(nums, len));

    }
    public static int maxCoins(int[][] dp, int[] nums, int i, int j)
    {   
        if(i > j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int maxi = 0;
        for(int index=i; index<=j; index++)
        {
            int cost = nums[i-1] * nums[index] * nums[j+1] + maxCoins(dp, nums, i, index-1) + maxCoins(dp, nums, index+1, j);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
    public static int maxCoins2(int[] nums, int len)
    {   
        int len2 = nums.length;
        int[][] dp = new int[len2][len2];
        for(int i=len; i>=1; i--)
        {
            for(int j=1; j<=len; j++)
            {
                if(i > j) continue;
                int maxi = 0;
                for(int index=i; index<=j; index++)
                {
                    int cost = nums[i-1] * nums[index] * nums[j+1] + dp[i][index-1] + dp[index+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][len];        
    }
}
