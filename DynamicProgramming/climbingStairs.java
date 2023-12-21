package DynamicProgramming;

public class climbingStairs {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];

        System.out.println(fact(n, dp));
        System.out.println(fact2(n));
        System.out.println(fact3(n, dp));

    }//1st Approach
    public static int fact(int n, int[] dp)
    {
        if(n<=2)
            return n;
        if(dp[n] != 0)
            return dp[n];
        return dp[n] = fact(n-1,dp) + fact(n-2, dp);
    }
    //2nd Approach
    public static int fact2(int n)
    {
        int prev = 1, prev2 = 1;
        for(int i=2; i<=n; i++)
        {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    //3rd Approach
    public static int fact3(int n, int[] dp)
    {
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
