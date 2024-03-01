package TwoPointers_SlidingWindow;

import java.util.HashMap;

public class minWindowSubstring {
    
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(str, t));
    }
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        int left = 0;
        int minLeft = 0, minLen = s.length() + 1;
        int cnt = 0;
        int len = s.length();
        for(int right = 0; right < len; right++){
            if(map.containsKey(s.charAt(right))){

                map.put(s.charAt(right), map.get(s.charAt(right))- 1);
                if(map.get(s.charAt(right)) >= 0) cnt++;

                while(cnt == t.length()){
                    if(right - left + 1 < minLen){
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left), map.get(s.charAt(left))+ 1);
                        if(map.get(s.charAt(left)) > 0) cnt--;
                    }
                    left++;
                }
            }
        }
        return (minLen > len) ? "" : s.substring(minLeft, minLeft+minLen);
    }
}
