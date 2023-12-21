package DynamicProgramming.partitionDp;

import java.util.Arrays;

public class partitionArrMaxSum {
    
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maxSum(arr, dp,  0, arr.length, k));
        System.out.println(maxSum2(arr, arr.length, k));
    
    }
    public static int maxSum(int[] nums, int[] dp, int index, int n, int k)
    {
        if(index == n)
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int len = 0, maxi = 0, maxAns = 0, res = 0;
        for(int i=index; i<Math.min(index+k, n); i++)
        {
            len = i-index+1;
            maxi = Math.max(maxi, nums[i]);
            maxAns = len*maxi + maxSum(nums, dp, i+1, n, k);
            res = Math.max(maxAns, res);
        }
        return dp[index] = res;
    
    }
    public static int maxSum2(int[] nums, int n, int k)
    {
        int[] dp = new int[n+1];

        for(int index = n; index>=0; index--)
        {
            if(index==n) continue;

            int maxi = 0, res = 0;
            for(int i=index; i<Math.min(index+k, n); i++)
            {
                int len = i-index+1;
                maxi = Math.max(maxi, nums[i]);
                int maxAns = len*maxi + dp[i+1];
                res = Math.max(maxAns, res);
            }
            dp[index] = res;
        }
        return dp[0];
    }
}
