package DynamicProgramming;

import java.util.Arrays;

public class knapSackProblem {
    public static void main(String[] args) {
        
        int n = 3, w = 6;
        int[] wgt = {3, 2, 5}, val = {30, 40, 60};
        int[][] dp = new int[n][w+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        int ans = knapsackProblem(dp, n-1, w, wgt, val);
        System.out.println(ans);
        System.out.println(knapsackProblem2(n, w, wgt, val));

    }
    public static int knapsackProblem(int[][] dp, int index, int w, int[] wgt, int[] val)
    {
        if(index == 0)
            if(wgt[index] <= w)
                return val[index];
            else
                return 0;
        if(dp[index][w]!=-1)
            return dp[index][w];

        int nonPick = knapsackProblem(dp, index-1, w, wgt, val);

        int pick = 0;
        if(wgt[index] <= w)
            pick = val[index] + knapsackProblem(dp, index-1, w-wgt[index], wgt, val);

        return dp[index][w] = Math.max(nonPick, pick);
    }
    public static int knapsackProblem2(int n, int w, int[] wgt, int[] val)
    {
        int[][] dp = new int[n][w+1];
        for(int i=0; i<=w; i++)
            if(wgt[0] <= i)
                dp[0][i] = val[0];
        
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=w; j++)
            {
                int nonPick = dp[i-1][j];

                int pick = 0;
                if(wgt[i] <= j)
                    pick = val[i] + dp[i-1][j-wgt[i]];

                dp[i][j] = Math.max(nonPick, pick);
            }
        }
        return dp[n-1][w];
            
                
    }
}
