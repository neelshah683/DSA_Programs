package DynamicProgramming;

import java.util.Arrays;

public class gridUniquePaths2 {
    public static void main(String[] args) {
        int[][] obsGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}           
        };
        int m=obsGrid.length;
        int n = obsGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(paths(m-1, n-1, dp, obsGrid));
        // System.out.println(paths2(m-1, n-1, dp, obsGrid));

    }
    public static int paths(int r, int c, int[][] dp, int[][] obsGrid)
    {
              
        if(r<0 || c<0)
            return 0;
        if(obsGrid[r][c] == 1)
            return 0; 
        if(r==0 && c==0)
            return 1;              
        if(dp[r][c]!= -1)
            return dp[r][c];
         
            
        int left = paths(r-1, c, dp, obsGrid);
        int right = paths(r, c-1, dp, obsGrid);

        return dp[r][c] = left + right;
    }
    //Tabulation
    public static int paths2(int r, int c, int[][] dp, int[][] obsGrid)
    {
        for(int i=0; i<=r; i++)
        {
            for(int j=0; j<=c; j++)
            {
                if(i<0 || j<0)
                    dp[i][j] = 0;
                else if(obsGrid[i][j] == 1)
                    dp[i][j] = 0; 
                else if(i==0 && j==0)
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
