package DynamicProgramming;

import java.util.Arrays;

public class cherryPickup2{
    public static void main(String[] args) {
        int[][] grid = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] row1 : dp)
            for(int[] row2 : row1)
                Arrays.fill(row2, -1);

        System.out.println(pathSum(grid, dp, 0, 0, n-1, m, n));
        System.out.println(pathSum2(grid, m, n));

    }
    public static int pathSum(int[][] grid, int[][][] dp, int i, int j1, int j2, int r, int c)
    {
        if(i==r-1)
            if(j1==j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];

        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];

        int maxi = 0;
        for(int dj1=-1; dj1<=1; dj1++)
        {
            for(int dj2=-1; dj2<=1; dj2++)
            {
                int val = 0;
                if(j1==j2)
                    val+= grid[i][j1];
                else
                    val+= grid[i][j1] + grid[i][j2];
                
                if(j1+dj1>=0 && j1+dj1 < c && j2+dj2>=0 && j2+dj2 < c)
                    val+= pathSum(grid, dp, i+1, j1+dj1, j2+dj2, r, c);

                maxi = Math.max(maxi, val);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public static int pathSum2(int[][] grid, int r, int c)
    {
        int[][][] dp = new int[r][c][c];

        for(int j1 = 0; j1<c; j1++)
            for(int j2 = 0; j2<c; j2++)
                if(j1 == j2)
                    dp[r-1][j1][j2] = grid[r-1][j1];
                else
                    dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];

        for(int i=r-2; i>=0; i--)
        {
            for(int j1 = 0; j1<c; j1++)
            {
                for(int j2 = 0; j2<c; j2++)
                {
                    int maxi = 0;
                    for(int dj1=-1; dj1<=1; dj1++)
                    {
                        for(int dj2=-1; dj2<=1; dj2++)
                        {
                            int val = 0;
                            if(j1==j2)
                                val+= grid[i][j1];
                            else
                                val+= grid[i][j1] + grid[i][j2];
                            
                            if(j1+dj1>=0 && j1+dj1 < c && j2+dj2>=0 && j2+dj2 < c)
                                val+=dp[i+1][j1+dj1][j2+dj2];

                            maxi = Math.max(maxi, val);
                        }
                    }
                    dp[i][j1][j2] = maxi; 
                }
                
            }
        }
        return dp[0][0][c-1] ;
    }
}