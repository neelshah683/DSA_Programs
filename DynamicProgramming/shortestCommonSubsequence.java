package DynamicProgramming;

public class shortestCommonSubsequence {
    
    public static void main(String[] args) {
        String s1 = "abac", s2 = "cab", s3 = "";
        String s = new StringBuilder(shortestComSubs(s1, s2)).reverse().toString();

        System.out.println(s);
    }
    public static String shortestComSubs(String s1, String s2)
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
        int n=len1, m=len2;
        String str = "";
        while(n>0 && m>0)
        {
            if(s1.charAt(n-1)==s2.charAt(m-1))
            {
               m--;
               str+=s1.charAt(n-1);
               n--;
            }
            else if(dp[n-1][m] > dp[n][m-1])
            {
                str+=s1.charAt(n-1);
                n--;
            }
            else
            {
                str+=s2.charAt(m-1);
                m--;
            }
        }
        while(n>0)
        {
            str+=s1.charAt(n-1);
            n--;
        }
        while(m>0)
        {
            str+=s2.charAt(m-1);
            m--;
        }
        return str;
    }
    
}
