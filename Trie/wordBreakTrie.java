package Trie;

import java.util.ArrayList;
import java.util.List;

class TrieNodeWB{
    TrieNodeWB[] links = new TrieNodeWB[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    void put(char ch, TrieNodeWB newNode){
        links[ch-'a'] = newNode;
    }
    TrieNodeWB get(char ch){
        return links[ch-'a'];
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}
class TrieBuild{
    public TrieNodeWB root;
    TrieBuild(){
        root = new TrieNodeWB();
    }
    void insert(String word){
        TrieNodeWB node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNodeWB());
            node = node.get(ch);
        }
        node.setEnd();
    }
    // boolean search(String word){
    //     TrieNodeWB node = root;
    //     for(char ch: word.toCharArray()){
    //         if(!node.containsKey(ch))
    //             return false;
    //         else if(node.containsKey(ch))
    //             node = node.get(ch);
            
    //         if(node.isEnd() == false)   return false;
    //     }
    //     return node.isEnd();
    // }
    boolean compute(String s){
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int indx = 0; indx < n; indx++){
            if(indx-1 == -1 || dp[indx-1] == true){
                TrieNodeWB node = root;
                for(int indx2 = indx; indx2 < n; indx2++){
                    char ch = s.charAt(indx2);
                    if(node.containsKey(ch)){
                        node = node.get(ch);
                        if(node.isEnd())
                            dp[indx2] = true;
                    }
                    else
                        break;
                }
            }
        }
        return dp[n-1];
    }
}

public class wordBreakTrie {
    
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> words = new ArrayList<>();
        words.add("cats");
        words.add("dog"); 
        words.add("sand");
        words.add("and");
        words.add("cat");

        TrieBuild tb = new TrieBuild();
        for(String word : words)
            tb.insert(word);

       System.out.println(tb.compute(s));
    }
}
