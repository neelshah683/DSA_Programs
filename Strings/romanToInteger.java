package Strings;

import java.util.HashMap;

public class romanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        if(s.length() == 1)
            return ans += map.get(s.charAt(0));
            
        int len = s.length();
        for(int index = len-1; index > 0; )
        {
            char ch1 = s.charAt(index);
            char ch2 = s.charAt(index-1);
            if(map.get(ch1) > map.get(ch2))
            {
                ans += (map.get(ch1) - map.get(ch2));
                index -= 2;
            }
            else
            {
                ans += map.get(ch1);
                index--;
            }
            if(index == 0)
                ans += map.get(s.charAt(0));

        }
        return ans;
    }
}
