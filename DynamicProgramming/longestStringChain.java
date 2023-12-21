package DynamicProgramming;

import java.util.Arrays;

public class longestStringChain {
    
    private static final String Comparator = null;
    public static void main(String[] args) {
        
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"} ;
        // Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println(longStringChain(words));
    }
    public static int longStringChain(String[] words)
    {
        int len = words.length, maxi = 1;
        int[] dp = new int[len];  
        Arrays.fill(dp, 1);
        for(int i=0; i<len; i++)
        {
            for(int prev=0; prev<i; prev++)
            {
                if(compareStr(words[i], words[prev]) && 1 + dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
    public static boolean compareStr(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        if(len1==len2+1)
        {
            int i=0, j=0;
            while(i < len1)
            {
                if(j < len2 && s1.charAt(i)==s2.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                    i++;
            }
            if(i==len1 && j==len2)
                return true;
            else    
                return false;    
            // return true;
        }
        
        return false;
    }
}
