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
class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNode());
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return true;
    }
}

public class implementTrie {
    public static void main(String[] args) {
    int n = 5;
	int type[] = {1, 1, 2, 3, 2};
	String value[] = {"hello", "help", "help", "hel", "hel"};
	Trie obj = new Trie();
	for (int i = 0; i < n; i++) {
		if (type[i] == 1) {
			obj.insert(value[i]);
		}
		else if (type[i] == 2) {
			if (obj.search(value[i])) {
				System.out.println( "true" );
			}
			else {
				System.out.println("false");
			}
		}
		else {
			if (obj.startsWith(value[i])) {
				System.out.println("true" );
			}
			else {
				System.out.println("false");
			}
		}
	}
    }
}
