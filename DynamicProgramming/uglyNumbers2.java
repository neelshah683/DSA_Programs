package DynamicProgramming;

/**
 * uglyNumbers2
 */
public class uglyNumbers2 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int p1 = 0, p2 = 0, p3 = 0;
        for(int indx = 1; indx < n; indx++){
            int mulTwo = dp[p1] * 2;
            int mulThree = dp[p2] * 3;
            int mulFive = dp[p3] * 5;

            dp[indx] = Math.min(mulFive, Math.min(mulTwo, mulThree));

            if(dp[indx] == mulTwo) p1++;
            if(dp[indx] == mulThree) p2++;
            if(dp[indx] == mulFive) p3++;
        }
        return dp[n-1];
    }
}