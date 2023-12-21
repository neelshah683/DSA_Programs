package DynamicProgramming;

import java.util.Arrays;

public class minFallingPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int minSum = Integer.MAX_VALUE;
        for(int j=0; j<n; j++)
        {
            minSum = Math.min(minSum, minFallPathSum(grid, m-1, j, dp));
        }        
        System.out.println(minSum);
        System.out.println(minFallPathSum2(grid, m, n));
        System.out.println(minFallPathSum3(grid, m, n));

    }
    public static int minFallPathSum(int[][] grid, int r, int c, int[][] dp)
    {
        if(r < 0 || c < 0 || c ==grid.length)
            return Integer.MIN_VALUE - 100;
        if(r==0)
            return grid[r][c];
        if(dp[r][c]!=-1)
            return dp[r][c];

        int ld = grid[r][c] + minFallPathSum(grid, r-1, c-1, dp);
        int up = grid[r][c] + minFallPathSum(grid, r-1, c, dp);
        int rd = grid[r][c] + minFallPathSum(grid, r-1, c+1, dp);

        return dp[r][c] = Math.min(ld, Math.min(up, rd));
    }
    public static int minFallPathSum2(int [][] grid, int m, int n)
    {
        int[][] dp = new int[m][n];
        for(int j=0; j<n; j++)
            dp[0][j] = grid[0][j];
        for(int i=1; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int ld = grid[i][j];
                if(j-1>=0)
                    ld+= dp[i-1][j-1];
                else
                    ld+= Integer.MAX_VALUE-100;

                int up = grid[i][j] + dp[i-1][j];

                int rd = grid[i][j];
                if(j+1 < n)
                    rd+= dp[i-1][j+1];
                else
                    rd+= Integer.MAX_VALUE-100;

                dp[i][j] = Math.min(ld, Math.min(up, rd));
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
        {
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
    public static int minFallPathSum3(int [][] grid, int m, int n)
    {
        int[] prev = new int[n];
        Arrays.fill(prev, 0);

         int[] curr = new int[n];
        Arrays.fill(curr, 0);

        for(int j=0; j<n; j++)
            prev[j] = grid[0][j];
        for(int i=1; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int ld = grid[i][j];
                if(j-1>=0)
                    ld+= prev[j-1];
                else
                    ld+= Integer.MAX_VALUE-100;

                int up = grid[i][j] + prev[j];

                int rd = grid[i][j];
                if(j+1 < n)
                    rd+= prev[j+1];
                else
                    rd+= Integer.MAX_VALUE-100;

                curr[j] = Math.min(ld, Math.min(up, rd));
            }
            prev = curr;
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
        {
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}
