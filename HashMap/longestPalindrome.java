package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class longestPalindrome {
    public static void main(String[] args) {
        String s = "abccdd";
        System.out.println(longPalindrome(s));
        System.out.println(longPalindrome2(s));

    }
    public static int longPalindrome(String s)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashSet<Integer> set = new HashSet<>();
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else
                map.put(s.charAt(i), 1);
        }
        int c = 0, ans= 0;
        for(int val : map.values())
            if(val % 2 != 0)
                c++;

        
        return (c>=1) ? len-c+1 : len;
    }
    public static int longPalindrome2(String s)
    {
       HashSet<Character> set = new HashSet<>();
        int c = 0;
       for(int i=0; i<s.length(); i++)
       {
        if(set.remove(s.charAt(i)))
            c++;
        else
            set.add(s.charAt(i));
       }
       return (set.isEmpty()) ? c*2 : c*2+1;
    }
}
