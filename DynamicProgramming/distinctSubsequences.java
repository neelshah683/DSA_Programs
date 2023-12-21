package DynamicProgramming;

import java.util.Arrays;

public class distinctSubsequences {
    public static void main(String[] args) {
        String s = "babgbag", t = "bag";
        int len1 = s.length(), len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(distSubs(len1, s, len2, t, dp));
        System.out.println(distSubs2(s, t));
        System.out.println(distSubs3(s, t));


    }
    public static int distSubs(int index1, String s1, int index2, String s2, int[][] dp)
    {
        if(index2 == 0)
            return 1;

        if(index1 == 0)
            return 0;

        if(dp[index1][index2]!=-1)
            return dp[index1][index2];

        if(s1.charAt(index1-1)==s2.charAt(index2-1))
        {
            return dp[index1][index2] = distSubs(index1-1, s1, index2, s2, dp) + distSubs(index1-1, s1, index2-1, s2, dp);
        }
        
        return  dp[index1][index2] = distSubs(index1-1, s1, index2, s2, dp);
    }
    public static int distSubs2(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<=len1; i++)
            dp[i][0] = 1;
        for(int i=1; i<=len2; i++)
            dp[0][i] = 0;
        
        for(int i=1; i<=len1; i++)
        {
            for(int j=1; j<=len2; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
    public static int distSubs3(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[] prev = new int [len2+1];
        int[] curr = new int [len2+1];

        prev[0] = 1;
        
        for(int i=1; i<=len1; i++)
        {
            curr[0] = 1;
            for(int j=1; j<=len2; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    curr[j] = prev[j] + prev[j-1];
                }
                else
                {
                    curr[j] = prev[j];
                }
            }
            prev = (int[])(curr.clone());
        }
        return prev[len2];
    }
}
