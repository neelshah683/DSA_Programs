package DynamicProgramming;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] grid = {
            {1},
            {2, 3},
            {3, 6, 7},
            {8, 9, 6, 10}
        };
        int m = grid.length;
        int[][] dp = new int[m][m];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(minSum(grid, dp, 0, 0));
        System.out.println(minSum2(grid));
        System.out.println(minSum3(grid));

    }
    public static int minSum(int[][] grid, int[][] dp, int r, int c)
    {
        if(r == grid.length-1)
            return grid[r][c];
        if(dp[r][c]!=-1)
            return dp[r][c];

        int down = grid[r][c] + minSum(grid, dp, r+1, c);
        int right = grid[r][c] + minSum(grid, dp, r+1, c+1);

        return dp[r][c] = Math.min(down, right);
    }
    public static int minSum2(int[][] grid)
    {
            int m = grid.length;
            int[][] dp = new int[m][m];
            for (int i=0; i<m; i++){
                dp[m-1][i] = grid[m-1][i];
        }
        for(int i=m-2; i>=0; i--)
        {
            for(int j=0; j<=i; j++)
            {
                int down = grid[i][j] + dp[i+1][j];
                int right = grid[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
    public static int minSum3(int[][] grid)
    {
            int m = grid.length;

            int[] prev = new int[m];
            Arrays.fill(prev, 0);

            for (int i=0; i<m; i++){
                prev[i] = grid[m-1][i];
        }
        for(int i=m-2; i>=0; i--)
        {
            int[] curr = new int[m];

            for(int j=0; j<=i; j++)
            {
                int down = grid[i][j] + prev[j];
                int right = grid[i][j] + prev[j+1];

                curr[j] = Math.min(down, right);
            }
            prev=curr;
        }
        return prev[0];
    }
}
