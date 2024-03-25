package Trie; 

class TrieNode{
      TrieNode[] links = new TrieNode[26];
      boolean flag = false;

      boolean containsKey(char ch){
        return links[ch-'a'] != null;
      }
      void put(char ch, TrieNode newNode){
        links[ch-'a'] = newNode;
      }
      TrieNode get(char ch){
        return links[ch-'a'];
      }
      void setEnd(){
        flag = true;
      }
      boolean isEnd(){
        return flag;
      }
}
 class Trie2{

      private TrieNode root;
      Trie2(){
        root = new TrieNode();
      }
      void insert(String word){
          TrieNode node = root;
          for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                  node.put(ch, new TrieNode());
            node = node.get(ch);
          }
          node.setEnd();
      }
      boolean search(String word){
        TrieNode node = root;
          for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                return false;
            else if(node.containsKey(ch)){
              node = node.get(ch);
              if(node.isEnd() == false) return false;
            }
          }
          return node.isEnd();
      }
}

public class longestStrWithAllPrefixes {
    
    public static void main(String[] args) {
        String[] a = {"n", "ni", "nin", "ninj", "ninja", "ninga"};
        Trie2 obj = new Trie2();

        for(String word : a){
            obj.insert(word);
          }
          String res = "";
          for(String word : a){
            if(obj.search(word)){
              if(res.length() < word.length()){
                  res = word;
              }
              else if(res.length() == word.length()){
                if(res.compareTo(word) > 0)
                  res = word;
              }
            }
                
          }
          System.out.println(res.length() == 0 ? "None" : res);
    }
}
