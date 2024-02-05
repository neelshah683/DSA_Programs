package Strings;

import java.util.HashMap;

public class isomorphicString {
    public static void main(String[] args) {
        String s1 = "badc";
        String s2 = "baba";
        System.out.println(isIsomorphic(s1, s2));
    }
     public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for(int index = 0; index < len; index++)
        {
            char ch1 = s.charAt(index);
            char ch2 = t.charAt(index);
            if(map.containsKey(ch1))
            {
                if(map.get(ch1) != ch2)
                    return false;
            }
            else
            {
                if(map.containsValue(ch2))
                    return false;
                map.put(ch1, ch2);
            }
        }
        return true;
    }
}
