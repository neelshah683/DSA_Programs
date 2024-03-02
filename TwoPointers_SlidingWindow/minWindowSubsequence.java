package TwoPointers_SlidingWindow;

import java.util.HashMap;

public class minWindowSubsequence {
    
    public static void main(String[] args) {
        String s1 = "abcdebdde";
        String s2 = "bde";
        System.out.println(minWindow(s1, s2));
    }
    //Need to do Backtrack to check for matching of subsequence,
    //if all chars are there in the substring
    public static String minWindow(String str1, String str2) {
        int start = 0, end = 0;
        int minLen = str1.length() + 1;
        int len = str1.length(), len2 = str2.length();
        int cnt = 0;
        for(int right = 0; right < len; right++){
            
            if(str1.charAt(right) == str2.charAt(cnt)) cnt++;
            
            if(cnt == len2){
                cnt--;
                end = right;
                
                while(cnt >= 0){
                    if(str1.charAt(right) == str2.charAt(cnt))  cnt--;
                    right--;
                }
                cnt++;
                right++;
                
                if(end - right + 1 < minLen){
                    start = right;
                    minLen = end - right + 1;
                }
            }
        }
        return minLen > len ? "" : str1.substring(start, start + minLen);
    }
}
