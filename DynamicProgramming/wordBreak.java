package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak {
    
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");

        System.out.println(wordBreak(s, list));
    }
    //TC: O(N*M*K) | SC: o(N) ---> DP | TOP-DOWN
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return compute(0, n, dp, s, wordDict);
    }
    public static boolean compute(int indx, int n, int[] dp, String s, List<String> wordDict){
        if(indx >= n)
            return true;
        
        if(dp[indx] != -1)  return dp[indx] == 1;

        for(String word : wordDict){
            int currLen = word.length();
            if(indx + currLen - 1 >= n) 
                continue;

            String temp = s.substring(indx, indx + currLen);
            if(temp.equals(word) && compute(indx + currLen, n, dp, s, wordDict)){
                dp[indx] = 1;
                return true;
            }
        }
        dp[indx] = 0;
        return false;
    }
}
