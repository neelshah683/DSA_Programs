package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordBreak2 {
    
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");

        System.out.println(wordBreak(s, list));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return compute(s, s.length(), wordDict, map);
    }
    public static List<String> compute(String s, int n, List<String> wordDict, Map<String, List<String>> map){

        if(s.length()==0)   return new ArrayList<String>(Arrays.asList(""));

        if(map.containsKey(s))
            return map.get(s);

        List<String> res = new ArrayList<>();
        List<String> subPart = new ArrayList<>();

        for(String word : wordDict){
            if(s.startsWith(word)){
                int currLen = word.length();
                subPart = compute(s.substring(currLen), n, wordDict, map);

                for(String ans : subPart){
                    String space = ans.length() == 0 ? "" : " ";
                    res.add(word + space + ans);
                }
            }
            
        }
        map.put(s, res);
        return res;
    }
}
