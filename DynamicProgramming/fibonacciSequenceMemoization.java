package DynamicProgramming;

public class fibonacciSequenceMemoization {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];

        System.out.println(fact(n, dp));

    }
    public static int fact(int n, int[] dp) 
    {
        if(n<=1)
            return n;
        if(dp[n] != 0)
            return dp[n];
        return dp[n] = fact(n-1,dp) + fact(n-2, dp);
    }
}
