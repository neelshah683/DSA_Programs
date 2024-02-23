package TwoPointers_SlidingWindow;
import java.util.HashMap;
import java.util.HashSet;
public class longSubstrWithoutRepeatChars {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(str));
    }
    //TC: O(N) SC: O(1)
    public static int lengthOfLongestSubstring1(String s) {        
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
    //TC: O(2N) SC: O(N) -> As HashSet taken //Sliding Window + Two pointers Solution
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length() == 1) return 1;
        int len = s.length();
        int left = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0; right < len; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
