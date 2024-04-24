package DynamicProgramming;

public class fibo_trinacciSequence {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        // System.out.println(tri_fibonacci(n, dp));
        System.out.println(tri_fibonacci2(n));
    }
    //Memoization ---> Top-Down Approach
    public static int tri_fibonacci(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(n == 2) return 1;
        if(dp[n] != 0) return dp[n];
        return dp[n] = tri_fibonacci(n-1, dp) + tri_fibonacci(n-2, dp) + tri_fibonacci(n-3, dp);
    }
    //Tabulation ---> Bottom-Up Approach
    public static int tri_fibonacci2(int n){
        int prev1 = 0, prev2 = 1, prev3 = prev2;
        for(int indx = 3; indx <= n; indx++){
            int curr = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = curr;
        }
        return prev3;
    }
}
