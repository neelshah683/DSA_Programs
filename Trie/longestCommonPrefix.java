package Trie;

class TrieNode2{
    TrieNode2[] links = new TrieNode2[26];
    int cntPrefix;

    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    void put(char ch, TrieNode2 newNode){
        links[ch-'a'] = newNode;
    }
    TrieNode2 get(char ch){
        return links[ch-'a'];
    }
    void incPrefix() { cntPrefix++ ;}
}
class Trie3 {

    TrieNode2 root;
    public Trie3() {
        root = new TrieNode2();
    }
    
    public void insert(String word) {
        TrieNode2 node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNode2());
            node = node.get(ch);
            node.incPrefix();
        }
    }
    
    public String search(String word, int n) {
        TrieNode2 node = root;
        for(int indx = 0; indx < word.length(); indx++){
            node = node.get(word.charAt(indx));
            if(node.cntPrefix != n) return word.substring(0, indx);
        }
        return word;
    }
}
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        Trie3 obj = new Trie3();
        
        for(String word : strs)
            obj.insert(word);
        
        return obj.search(strs[0], strs.length);
    }
}
public class longestCommonPrefix {
    
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String[] strs = {"flower", "flight", "flow"};
        System.out.println("Longest Common Prefix: "+s1.longestCommonPrefix(strs));
    }
}
