package DynamicProgramming;
import java.util.*;
public class longIdealSubsequence {
    
    public static void main(String[] args) {
        String s = "abcd";
        int k  = 3, n = s.length();
        int[][] dp = new int[n][27];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        System.out.println(idealSubs(s, dp, 0, '{', k));
        System.out.println(idealSubs2(s, k));
        System.out.println(idealSubs3(s, k));
        System.out.println(idealSubs4(s, k));

    }
    //Memoization: TC: O(N * 27) | SC: O(N * 27) + Recursion-Stack Space
    public static int idealSubs(String s, int[][] dp, int indx, char last, int k){
        if(indx == s.length())  return 0;
        if(dp[indx][last - 'a'] != -1) return dp[indx][last - 'a'];

        int take = 0;
        
        if(last == '{' || Math.abs(last - s.charAt(indx)) <= k)
            take = 1 + idealSubs(s, dp, indx+1, s.charAt(indx), k);
        
        int nonTake = idealSubs(s, dp, indx+1, last, k);

        return dp[indx][last-'a'] = Math.max(take, nonTake);
    }
    //Tabulation: TC O(N * 124) | SC: O(N * 124)
    public static int idealSubs2(String s, int k){
        int n = s.length();
        int[][] dp = new int[n+1][124];
        
        for(int indx = n-1; indx >= 0; indx--){
            for(char ch ='a'; ch <= '{'; ch++){
                int take = 0;
        
                if(ch == '{' || Math.abs(ch - s.charAt(indx)) <= k)
                    take = 1 + dp[indx+1][s.charAt(indx)];
                
                int nonTake = dp[indx+1][ch];

                dp[indx][ch] = Math.max(take, nonTake);
            }
        }
        return dp[0]['{'];
    }
    
    //Tabulation: TC O(2N * 124) | SC: O(124)
    public static int idealSubs3(String s, int k){
        int n = s.length();
        
        int[] prev = new int[124];
        int[] curr = new int[124];
        
        for(int indx = n-1; indx >= 0; indx--){
            for(char ch ='a'; ch <= '{'; ch++){
                int take = 0;
        
                if(ch == '{' || Math.abs(ch - s.charAt(indx)) <= k)
                    take = 1 + prev[s.charAt(indx)];
                
                int nonTake = prev[ch];

                curr[ch] = Math.max(take, nonTake);
            }
            prev = (int[])(curr.clone());
        }
        return prev['{'];
    }
        //Tabulation: TC O(N * 124) | SC: O(124)

    public static int idealSubs4(String s, int k){
        int n = s.length();
        int ans = 0;
        int[] prev = new int[124];
        
        for(int indx = 0; indx < n; indx++){
            int maxLen = 0;
            for(char ch ='a'; ch <= '{'; ch++){
                if(ch == '{' || Math.abs(ch - s.charAt(indx)) <= k)
                    maxLen = Math.max(maxLen, 1 + prev[ch-'a']);
            }
            prev[s.charAt(indx)-'a'] = maxLen;
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }
}
