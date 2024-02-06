package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class sortCharactersFrequency {
    public static void main(String[] args) {
        String s = "tree";
    }
    public String frequencySort(String s) {
        int len = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> (map.get(b) - map.get(a)));
        maxHeap.addAll(map.keySet());

        String res = "";
        while(!maxHeap.isEmpty())
        {
            char c = maxHeap.poll();
            for(int i=0; i<map.get(c); i++)
                res += c;
        }
        return res;
    }
    public static String frequencySort1(String s) {
        int len = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> (map.get(b) - map.get(a)));
        
        String res = "";
        for(char ch: list)
            for(int i=0; i<map.get(ch); i++)
                res += ch;
        
        return res;
    }
}
