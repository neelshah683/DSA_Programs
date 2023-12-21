package DynamicProgramming;

public class min_insertion_makeStr_Palindrome {
    
    public static void main(String[] args) {
        String s = "leetcode", s1 = new StringBuilder(s).reverse().toString();
        System.out.println(minInsertPDR(s, s1));
        System.out.println(minInsertPDR2(s, s1));

    }
    public static int minInsertPDR(String s1, String s2)
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
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return len1 - dp[len1][len2];
       }
       public static int minInsertPDR2(String s1, String s2)
        {
        int len1 = s1.length(), len2 = s2.length();
        
        int[] prev = new int[len2+1];
        int[] curr = new int[len2+1];

        for(int i=1; i<=len1; i++)
        {
            for(int j=1; j<=len2; j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = (int[])(curr.clone());
        }
        return len1 - prev[len2];
       }
}
