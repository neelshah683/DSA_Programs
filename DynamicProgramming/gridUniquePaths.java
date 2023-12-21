package DynamicProgramming;

import java.util.Arrays;

public class gridUniquePaths {
    
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(paths(m-1, n-1, dp));
        System.out.println(paths2(m-1, n-1, dp));

    }
    //Memoization
    public static int paths(int r, int c, int[][] dp)
    {
        if(r==0 || c==0)
            return 1;

         if(dp[r][c]!= -1)
            return dp[r][c];
            
        int left = paths(r-1, c, dp);
        int right = paths(r, c-1, dp);

        return dp[r][c] = left + right;
    }
    //Tabulation
    public static int paths2(int r, int c, int[][] dp)
    {
        for(int i=0; i<=r; i++)
        {
            for(int j=0; j<=c; j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 1;
                else{
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];

                    dp[i][j] = left + right;
                }
                
            }
        }
        return dp[r][c];
    }
    
}
