package Trie;
import java.util.*;

class Node {
    Node links[] = new Node[26];
    int cntPrefix = 0;

    public Node() {
    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;

    }

    void increasePrefix() {
        cntPrefix++;
    }

    int getPrefix() {
        return cntPrefix;
    }
}

 class TrieScore {
    private Node root;

    TrieScore() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(char ch : word.toCharArray()){
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increasePrefix();
        }
    }

    public int countPrefix(String word) {
        Node node = root;
        int preCount = 0;
        for(char ch : word.toCharArray()){
            if (node.containsKey(ch)){
                node = node.get(ch);
                preCount += node.getPrefix();
            }   
        }
        return preCount;
    }

}
public class scorePrefixString {
    
    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};
        System.out.println(Arrays.toString(sumPrefixScores(words)));
    }
    public static int[] sumPrefixScores(String[] words) {
        TrieScore t = new TrieScore();
        int[] res = new int[words.length];

        //TC: O(N * Len(N)) | SC: O(N * Len(N))
        for(String word: words)
            t.insert(word);
        
        int indx = 0;

        //TC: O(N * Len(N)) | SC: O(N)
        for(String word: words)
            res[indx++] = t.countPrefix(word);

        //Overall TC: O(N * Len(N)) | SC: O(N * Len(N))
        return res;
    }
}
