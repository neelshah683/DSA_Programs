package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class longestPalindromeSubstring {
    
    public static void main(String[] args) {
        String s1 = "aacabdkacaa";
        String s2 = "";
        for(int i=s1.length()-1; i>=0; i--)
            s2+=s1.charAt(i);
        System.out.println(longCommonSubstr2(s1, s2));
        System.out.println(longestPalindrome(s1));
    }
    public static String longCommonSubstr2(String s1,String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        int maxi = 0;
        String ans = "";

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
                        if(dp[i][j] > maxi)
                        {
                            String temp = s1.substring(i-dp[i][j], i);
                            StringBuilder revTemp = new StringBuilder(temp);
                            revTemp.reverse();
                            if(revTemp.toString().equals(temp)){
                                maxi = dp[i][j];
                                ans = temp;
                            }
                        }
                    }
                    else
                        dp[i][j] = 0;                    
                }
        }
        System.out.println(maxi);
        return ans;
    }
    public static String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }
        
        return "";
    }
    
    private static boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}
