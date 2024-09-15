package DynamicProgramming.BitMasking;

import java.util.HashMap;
import java.util.Map;

public class vowelsEvenCount {
    
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(s));
    }
    public static int findTheLongestSubstring(String s) {
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        //TC : O(N) SC: O(vowels)
        int mask = 0, maxLen = 0;
        for(int indx = 0; indx < n; indx++){

            if(s.charAt(indx) == 'a') mask ^= (1 << 0);
            else if(s.charAt(indx) == 'e') mask ^= (1 << 1);
            else if(s.charAt(indx) == 'i') mask ^= (1 << 2);
            else if(s.charAt(indx) == 'o') mask ^= (1 << 3);
            else if(s.charAt(indx) == 'u') mask ^= (1 << 4);

            if(map.containsKey(mask))
                maxLen = Math.max(maxLen, indx - map.get(mask));
            else
                map.put(mask, indx);
        }
        //Overall TC: O(N) SC: O(vowels = 5) ~= O(1)
        return maxLen;
    }
}
