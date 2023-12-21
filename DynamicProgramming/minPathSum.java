package DynamicProgramming;

import java.util.Arrays;

public class minPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(minSum(grid, dp, m-1, n-1));
        System.out.println(minSum2(grid, dp, m-1, n-1));

    }
    public static int minSum(int[][] grid, int[][] dp, int r, int c)
    {
        if(r == 0 && c==0)
            return grid[r][c];
        if(r == -1 || c == -1)
            return Integer.MAX_VALUE-100;
        if(dp[r][c]!=-1)
            return dp[r][c];
        int up = grid[r][c] + minSum(grid, dp, r-1, c);
    
        int left = grid[r][c] + minSum(grid, dp, r, c-1);

        return dp[r][c] = Math.min(up, left);
    }
    public static int minSum2(int[][] grid, int[][] dp, int r, int c)
    {
        for(int i=0; i<=r; i++)
        {
            for(int j=0; j<=c; j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i>0)
                        up+=dp[i-1][j];
                    else
                        up+=Integer.MAX_VALUE-100;

                    int left = grid[i][j];
                    if(j>0)
                        left+=dp[i][j-1];
                    else
                        left+=Integer.MAX_VALUE-100;
                }
            }
        }
        return dp[r][c];
    }
}
