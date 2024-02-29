package TwoPointers_SlidingWindow;

import java.util.HashSet;

public class longSubstrWithKUniqueChars {
    //Also known as Longest substring with atmost k distinct characters
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        System.out.println(longestkSubstr(str, k));
    }
    public static int longestkSubstr(String s, int k) {
        int maxLen = -1, cntChars = 0;
        int len = s.length();
        int left = 0;
        int[] count = new int[26];
        for(int right = 0; right < len; right++){
            if(count[s.charAt(right)-'a'] == 0)
                cntChars++;
            
            while(cntChars > k){
                count[s.charAt(left)-'a']--;
                if(count[s.charAt(left)-'a'] == 0)
                        cntChars--;
                left++;
            }
            count[s.charAt(right)-'a']++;
            maxLen = Math.max(maxLen, right - left + 1);

        }
        int cntChars2 = 0;
        for(int index = 0; index < count.length; index++)
            if(count[index] > 0)
                cntChars2++;
                
        return cntChars2 < k ? -1 : maxLen;
    }

}
