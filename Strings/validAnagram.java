package Strings;

import java.util.HashMap;

public class validAnagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2)); 
    }
     public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for(char ch : t.toCharArray())
            if(map.containsKey(ch) && map.get(ch) != 0)
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            else
                return false;
        return true;
    }
}
