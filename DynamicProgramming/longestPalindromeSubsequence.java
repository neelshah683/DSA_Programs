package DynamicProgramming;

import java.util.Arrays;

public class longestPalindromeSubsequence {
    public static void main(String[] args) {
        String s1 = "bbbab";
        String s2 = "";

        for(int i=s1.length()-1; i>=0; i--)
            s2+= s1.charAt(i);

        int len1 = s1.length(), len2 = s2.length();

        int[][] dp = new int[len1+1][len2+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);

        System.out.println(longPdrSeq(len1, s1, len2, s2, dp));
        System.out.println(longPdrSeq2(s1, s2));
        System.out.println(longPdrSeq3(s1, s2));

    }
    public static int longPdrSeq(int index1, String s1, int index2, String s2, int[][] dp)
    {
        if(index1 == 0 || index2 == 0)
            return 0;
        if(dp[index1][index2]!=-1)  
            return dp[index1][index2];

        if(s1.charAt(index1-1) == s2.charAt(index2-1))
            return dp[index1][index2] = 1 + longPdrSeq(index1-1, s1, index2-1, s2, dp);
        else    
            return dp[index1][index2] = Math.max(longPdrSeq(index1-1, s1, index2, s2, dp), longPdrSeq(index1, s1, index2-1, s2, dp));
    }
    public static int longPdrSeq2(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len2+1][len2+1];  
        
        for(int i=0; i<=len1; i++)
        {
            for(int j=0; j<=len2; j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }
    public static int longPdrSeq3(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();

        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];

        for(int i=1; i<=len1; i++)
        {
            for(int j=1; j<=len2; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = (int[])(curr.clone());
        }
        return prev[len2];
    }
}
