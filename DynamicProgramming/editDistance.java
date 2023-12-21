package DynamicProgramming;

import java.util.Arrays;

public class editDistance {
    public static void main(String[] args) {
        String word1 = "", word2 = "a";
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(countOps(len1, word1, len2, word2, dp));
        System.out.println(countOps2(word1, word2));
        System.out.println(countOps3(word1, word2));
    }
    public static int countOps(int index1, String s1, int index2, String s2, int[][] dp)
    {       
        if(index1 == 0)
            return index2;
        if(index2 == 0)
            return index1;
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];

        if(s1.charAt(index1-1) == s2.charAt(index2-1))
            return countOps(index1-1, s1, index2-1, s2, dp);
        else
            return 1 + Math.min(countOps(index1-1, s1, index2, s2, dp),Math.min(countOps(index1-1, s1, index2-1, s2, dp), countOps(index1, s1, index2-1, s2, dp)));
    }
    public static int countOps2(String s1, String s2)
    {       
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<=len1; i++)
            dp[i][0] = i;
        for(int j=0; j<=len2; j++)
            dp[0][j] = j;
        for(int i=1; i<=len1; i++)
        {
            for(int j=1; j<=len2; j++)
            {
                 if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]));
            }
        }
        return dp[len1][len2];
    }
    public static int countOps3(String s1, String s2)
    {       
        int len1 = s1.length(), len2 = s2.length();
        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];

        for(int i=0; i<=len2; i++)
            prev[i] = i;
        
        for(int i=1; i<=len1; i++)
        {
            curr[0] = i;
            for(int j=1; j<=len2; j++)
            {
                 if(s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = prev[j-1];
                else
                    curr[j] = 1 + Math.min(prev[j],Math.min(prev[j-1], curr[j-1]));
            }
            prev = (int[])(curr.clone());
        }
        return prev[len2];
    }

}
