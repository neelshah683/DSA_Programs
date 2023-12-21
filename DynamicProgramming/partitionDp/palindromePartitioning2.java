package DynamicProgramming.partitionDp;

import java.util.Arrays;

public class palindromePartitioning2 {
    public static void main(String[] args) {
        String s = "bababc";
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        System.out.println(pdrPartition(dp, s, 0, s.length())-1);
        System.out.println(pdrPartition2(s)-1);

        //OPTIMIZED APPROACH
        System.out.println(minCuts(s));
    }
    public static int pdrPartition(int[] dp, String s, int index, int end)
    {
        if(index==end)
            return 0;
        if(dp[index]!=-1)
            return dp[index];

        int mini = Integer.MAX_VALUE;
        for(int i=index; i<end; i++)
        {   
            if(isPDR(s, index, i))
            {
                int cuts = 1 + pdrPartition(dp, s, i+1, end);
                mini = Math.min(mini, cuts); 
            }
             
        }
        return dp[index] = mini;
    }
    public static boolean isPDR(String temp, int start, int end)
    {
        while(start<=end)
        {
            if(temp.charAt(start)==temp.charAt(end))
            {
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
    public static int pdrPartition2(String s)
    {
        int len = s.length();
        int[] dp = new int[len+1];        
       
        for(int index=len; index>=0; index--)
        {
            if(index==len) continue;

            int mini = Integer.MAX_VALUE;
            for(int i=index; i<len; i++)
            {   
                if(isPDR(s, index, i))
                {
                    int cuts = 1 + dp[i+1];
                    mini = Math.min(mini, cuts); 
                }
                
            }
            dp[index] = mini;
        }
        return dp[0];
    }
    public static int minCuts(String s)
    {
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] pdr = new boolean[len][len];

        for(int i=0; i<len; i++)
        {
            int minCuts = i;
            for(int j=0; j<=i; j++)
            {
                if(s.charAt(i)==s.charAt(j) & (j+1 > i-1 || pdr[j+1][i-1]))
                {
                    pdr[j][i] = true;
                    minCuts = (j==0) ? 0 : Math.min(minCuts, dp[j-1]+1);
                }
            }
            dp[i] = minCuts;
        }
        return dp[len-1];
    }
}
