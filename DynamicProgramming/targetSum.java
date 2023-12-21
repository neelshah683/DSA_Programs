package DynamicProgramming;

import java.util.Arrays;

public class targetSum {
    static int total = 5;
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1};
        int target = 3, n = nums.length;
        int[][] dp = new int[n+1][2*total+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(tarSum(n, 0, dp, nums, target));
        System.out.println(tarSum2(0, nums, target));

    }
    public static int tarSum(int index, int sum, int[][] dp, int[]nums, int target)
    {
        if(target == sum && nums.length==1)
            return 1;
        if(index == 0)
            if(sum == target)
                return 1;
            else
                return 0;
        if(dp[index][total+sum]!=-1)
            return dp[index][total+sum];

        int nonPick = tarSum(index-1, sum+nums[index-1], dp, nums, target);
        int pick = tarSum(index - 1, sum-nums[index-1], dp, nums,target );

        return dp[index][total+sum] = nonPick + pick;
    }
    public static int tarSum2(int sum, int[]nums, int target)
    {
        int n = nums.length, total = 5, n1=2*total+1;
        int[][] dp = new int[n+1][n1];

        // dp[0][target] = 1;

        for(int i=1; i<=n; i++)
        {
            for(int j=0; j<n1; j++)
            {
                if(i==0)
                    if(j==target)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                else{
                        int nonPick = dp[i-1][j+nums[i-1]];
                        int pick = dp[i-1][j-nums[i-1]];

                        dp[i][total+j] = nonPick + pick;
                }   
                
            }
        }
        return dp[n][0];
    }
}
