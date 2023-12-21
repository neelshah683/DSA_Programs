package DynamicProgramming;

public class partitionSubset_minDifference {
    
    public static void main(String[] args) {
        
        int[] nums = {4, 3, 1, 1};

        int sum = 0;
        for(int n : nums)
            sum+=n;
        
        int target = sum;
        System.out.println(subsetSum(nums, target));
    }
    public static int subsetSum(int[] nums, int k)
    {
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++)
            dp[i][0] = true;

        if(nums[0] <= k)
            dp[0][nums[0]] = true;

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<=k; j++)
            {
                boolean nonTake = dp[i-1][j];
                
                boolean take = false;
                if(j >= nums[i])
                    take = dp[i-1][j-nums[i]];

                dp[i][j] = nonTake || take;
            }
        }       
        
        int s1 = 0, s2 = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<=k/2; i++)
        {
            if(dp[n-1][i] == true)
            {
                s1 = i;
                s2 = k-i;

                min = Math.min(min, Math.abs(s2 - s1));
            }
        }

        return min;
    }
}
