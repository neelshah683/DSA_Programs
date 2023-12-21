package DynamicProgramming;

import java.util.Arrays;

public class regularExpressionMatching {
    public static void main(String[] args) {
        String s1 = "ab*a*c*a", s2 = "aaa";
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(expMatch(len1 - 1, s1, len2 - 1, s2, dp));
        System.out.println(expMatch2(s1, s2));

    }

    public static boolean expMatch(int index1, String s1, int index2, String s2, int[][] dp) {
        if (index1 < 0 && index2 < 0)
            return true;
        if (index2 < 0) {
                if (s1.charAt(index1) == '*')
                    return expMatch(index1 - 2, s1, index2, s2, dp);
                else
                    return false;     
        }
        if (index1 < 0)
            return false;
        if(dp[index1][index2]!=-1)
            return dp[index1][index2]==1 ? true : false;

        if (s1.charAt(index1) == '*') {
            boolean res = false;
            if (s1.charAt(index1 - 1) == s2.charAt(index2) || s1.charAt(index1 - 1) == '.')
                res = res || expMatch(index1, s1, index2 - 1, s2, dp);
            
            dp[index1][index2] = (res || expMatch(index1 - 2, s1, index2, s2, dp)) ? 1 : 0;
            return dp[index1][index2]==1 ? true : false;
        }
        if (s1.charAt(index1) == '.' || s1.charAt(index1) == s2.charAt(index2)) {
            dp[index1][index2] = expMatch(index1 - 1, s1, index2 - 1, s2, dp) ? 1 : 0;
            return dp[index1][index2]==1 ? true : false;
        }
        return false;

    }

    public static boolean expMatch2(String s1, String s2) 
    {
        int len1 = s1.length(), len2 = s2.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;

        for(int i=1; i<=len1; i++)
        {
            for(int j=0; j<=len2; j++)
            {
                if (j == 0) 
                {
                    if (s1.charAt(i-1) == '*')
                        dp[i][j] = dp[i-2][j];
                    else
                        dp[i][j] = false;     
                }
                else if (s1.charAt(i-1) == '*') 
                {
                    if (s1.charAt(i - 2) == s2.charAt(j-1) || s1.charAt(i-2) == '.')
                        dp[i][j] = dp[i][j-1];                    
                    dp[i][j] = dp[i][j] || dp[i-2][j];
                }
                else if (s1.charAt(i-1) == '.' || s1.charAt(i-1) == s2.charAt(j-1)) 
                {
                    dp[i][j] = dp[i-1][j-1];
                }    
            }
        }
        return dp[len1][len2];
    }
}