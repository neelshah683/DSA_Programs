package TwoPointers_SlidingWindow;
import java.util.HashMap;
public class longSubstrWithoutRepeatChars {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
    //TC: O(N) SC: O(1)
    public static int lengthOfLongestSubstring(String s) {        
        int len = s.length();
        if(len == 1) return 1;
        int start = 0, maxStr = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int index = 0; index < len; index++){
            if(map.containsKey(s.charAt(index)))
                start = Math.max(start, map.get(s.charAt(index)) + 1);
            map.put(s.charAt(index), index);
            maxStr = Math.max(maxStr, index - start + 1);
        }
        return maxStr;
    }
}
