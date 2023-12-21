package DynamicProgramming;

import java.util.Arrays;

public class longestCommonSubstring {

        public static void main(String[] args) {
            
            String s1 = "abcd", s2 = "abzd";
            System.out.println(longCommonSubstr(s1.length(), s1, s2.length(), s2));
           int ans = longCommonSubstr2(s1, s2);
           System.out.println(ans);
           System.out.println(longCommonSubstr3(s1, s2));

        }
        public static int longCommonSubstr(int index1, String s1, int index2, String s2)
        {
            if(index1 == 0 || index2 == 0)  
                return 0;

            if(s1.charAt(index1-1) ==  s2.charAt(index2-1))
                return 1 + longCommonSubstr(index1-1, s1, index2-1, s2);
            else
                return 0 + longCommonSubstr(index1-1, s1, index2-1, s2);
        }
    public static int longCommonSubstr2(String s1,String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        int ans = 0;
        for(int i=0; i<=len1; i++)
        {
            for(int j=0; j<=len2; j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                    {
                        dp[i][j] = 1 + dp[i-1][j-1];
                        ans = Math.max(ans, dp[i][j]);
                    }
                    else
                        dp[i][j] = 0;                    
                }
        }
        return ans;
    }
    public static int longCommonSubstr3(String s1,String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[] prev = new int[len2+1];
        Arrays.fill(prev, 0);
        int[] curr = new int[len2+1];
        Arrays.fill(curr, 0);

        // for(int i=0; i<=len2; i++)
        //     prev[i] = 0;

        int ans = 0;
        for(int i=1; i<=len1; i++)
        {
            for(int j=1; j<=len2; j++)
            {
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                    {
                        curr[j] = 1 + prev[j-1];
                        ans = Math.max(ans, curr[j]);
                    }
                    else
                        curr[j] = 0;                    
            }
            prev = (int[])(curr.clone());
        }
        return ans;
    }
}