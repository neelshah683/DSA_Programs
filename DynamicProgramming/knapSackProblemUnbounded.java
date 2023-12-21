package DynamicProgramming;

public class knapSackProblemUnbounded {
    public static void main(String[] args) {
        int[] wgt = {2, 4, 6}, val = {5, 11, 13};
        int n = wgt.length, w = 10;
        System.out.println(unboundKnapsack(n-1, w, wgt, val));
        System.out.println(unboundKnapsack2(w, wgt, val));
        System.out.println(unboundKnapsack3(w, wgt, val));


    }
    public static int unboundKnapsack(int index, int w, int[] wgt, int[] val)
    {
        if(index==0)
            if(wgt[index] <= w)
                return (w/wgt[index]) * val[index];
            else
                return 0;

        int nonPick = unboundKnapsack(index-1, w, wgt, val);
        int pick = 0;
        if(wgt[index] <= w)
            pick = val[index] + unboundKnapsack(index, w-wgt[index], wgt, val);

        return Math.max(nonPick, pick);
    }
    public static int unboundKnapsack2(int w, int[] wgt, int[] val)
    {
        int n = wgt.length;
        int[][] dp = new int[n][w+1];

        for(int i=0; i<=w; i++)
            if(wgt[0] <= i)
                dp[0][i] = (i/wgt[0]) * val[0];
            

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=w; j++)
            {
                int nonPick = dp[i-1][j];
                int pick = 0;
                if(wgt[i] <= j)
                    pick = val[i] + dp[i][j-wgt[i]];

                dp[i][j] = Math.max(nonPick, pick);
            }
        }

        return dp[n-1][w];
    }
    public static int unboundKnapsack3(int w, int[] wgt, int[] val)
    {
        int n = wgt.length;
        int[] prev = new int[w+1];

        for(int i=0; i<=w; i++)
            if(wgt[0] <= i)
                prev[i] = (i/wgt[0]) * val[0];
            

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<=w; j++)
            {
                int nonPick = prev[j];
                int pick = 0;
                if(wgt[i] <= j)
                    pick = val[i] + prev[j-wgt[i]];

                prev[j] = Math.max(nonPick, pick);
            }
        }

        return prev[w];
    }
    
}
