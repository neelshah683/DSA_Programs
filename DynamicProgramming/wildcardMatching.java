package DynamicProgramming;

import java.util.Arrays;

public class wildcardMatching {
    
    public static void main(String[] args) {
        String s1 = "**abcd", s2 = "abcd";
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1][len2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(wildCardMatch(len1-1, s1, len2-1, s2, dp));
        System.out.println(wildCardMatch2(s1, s2));
        System.out.println(wildCardMatch3(s1, s2));
  
    }
    public static boolean wildCardMatch(int index1, String s1, int index2, String s2, int[][] dp)
    {
        if(index1 < 0 && index2 < 0)
            return true;
        if(index1 < 0 && index2 >= 0)
            return false;
        if(index1 >=0 && index2 < 0)
        {
            for(int i = index1; i>=0; i--)
                if(s1.charAt(i) != '*')
                    return false;

            return true;
        }
        if(dp[index1][index2]!=-1)
            return dp[index1][index2]==1 ? true : false;

       if(s1.charAt(index1) == s2.charAt(index2) || s1.charAt(index1) == '?')
       {
            dp[index1][index2] = wildCardMatch(index1-1, s1, index2-1, s2, dp) ? 1 : 0;
            return dp[index1][index2]==1 ? true :  false;
       }
        else if(s1.charAt(index1) == '*')
        {
            dp[index1][index2] = wildCardMatch(index1-1, s1, index2, s2, dp) || wildCardMatch(index1, s1, index2-1, s2, dp) ? 1 : 0;
            return dp[index1][index2]==1 ? true :  false;
        }

        return false;
    }
    public static boolean wildCardMatch2 (String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];

        dp[0][0] =  true;         

        for(int i=1; i<=len1; i++)
        {
              if(s1.charAt(i-1)=='*')
                dp[i][0] = dp[i-1][0] && true;

            for(int j=1; j<=len2; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(s1.charAt(i-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }
        return dp[len1][len2];
    }
    public static boolean wildCardMatch3(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        boolean[] prev= new boolean[len2+1];

        prev[0] =  true;           

        for(int i=1; i<=len1; i++)
        {
            boolean[] curr= new boolean[len2+1];

            if(s1.charAt(i-1)=='*')
                curr[0] = prev[0] && true;

            for(int j=1; j<=len2; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')
                    curr[j] = prev[j-1];
                else if(s1.charAt(i-1)=='*')
                    curr[j] = prev[j] || curr[j-1];
                else
                    curr[j] = false;
            }
            prev = (boolean[])(curr.clone());
        }
        return prev[len2];
    }
}
