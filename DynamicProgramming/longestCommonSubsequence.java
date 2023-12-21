package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class longestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "babgbag", s2 = "bag";
        int len1 = s1.length(), len2 = s2.length();
        System.out.println(longCommonSubs(len1-1, s1, len2-1, s2));
        System.out.println(longCommonSubs2(s1, s2));
        System.out.println(longCommonSubs3(s1, s2));

    }
    public static int longCommonSubs(int index1, String s1, int index2, String s2)
    {
        if(index1 < 0 || index2 < 0)
            return 0;

        if(s1.charAt(index1) == s2.charAt(index2))
        {
            return 1 + longCommonSubs(index1-1, s1, index2-1, s2);
        }
        else
            return Math.max(longCommonSubs(index1-1, s1, index2, s2), longCommonSubs(index1, s1, index2-1, s2));
    }
    public static int longCommonSubs2(String s1,String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

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
    public static int longCommonSubs3(String s1,String s2)
    {
        int n=s1.length();
        int m=s2.length();
    
        int prev[]=new int[m+1];
        int cur[]=new int[m+1];
        
        // Base Case is covered as we have initialized the prev and cur to 0.
        
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    cur[ind2] = 1 + prev[ind2-1];
                else
                    cur[ind2] = 0 + Math.max(prev[ind2],cur[ind2-1]);
            }
            prev=(int[])(cur.clone());
        }
        
        return prev[m];
    }
}
