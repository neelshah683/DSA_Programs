package DynamicProgramming.partitionDp;
import java.util.Arrays;

public class matrixChainMultiplication {
 
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(matrixMul(arr, dp,  1, arr.length-1));
        System.out.println(matrixMul2(arr));

    }
    public static int matrixMul(int[] nums, int[][] dp, int start, int end)
    {
        if(start == end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];

        int mini = Integer.MAX_VALUE;
        for(int k=start; k < end; k++)
        {
            int steps = nums[start-1] * nums[k] * nums[end] + matrixMul(nums, dp, start, k) + matrixMul(nums, dp, k+1, end);
            mini = Math.min(steps, mini);
        }
        return dp[start][end] = mini;
    }
    public static int matrixMul2(int[] nums)
    {
        int[][] dp = new int[nums.length][nums.length];

        for(int i=nums.length-1;  i>=1; i--)
        {
            for(int j=1; j<=nums.length-1; j++)
            {
                if(i==j)
                    continue;
                int mini = Integer.MAX_VALUE;
                for(int k=i; k < j; k++)
                {
                    int steps = nums[i-1] * nums[k] * nums[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(steps, mini);
                }
                 dp[i][j] = mini;
            }
        }
        return dp[1][nums.length-1];
    }
}
