package Trie;

class TrieNode4{

	TrieNode4[] links = new TrieNode4[26];

	boolean containsKey(char ch){
		return links[ch-'a'] != null;
	}
	void put(char ch, TrieNode4 newNode){
		links[ch-'a'] = newNode;
	}
	TrieNode4 get(char ch){
		return links[ch-'a'];
	}
}
class Trie4{
	TrieNode4 root;
    int cntStr = 0;
	Trie4(){
		root = new TrieNode4();
	}
	void insert(String word){
		TrieNode4 node = root;
		for(char ch : word.toCharArray()){
			if(!node.containsKey(ch)){
				node.put(ch, new TrieNode4());
                cntStr++;
            }
			node = node.get(ch);
		}
	}
    int cntstr(){
		return cntStr;
	}
}
public class countDistinctSubstrings {
    
    public static void main(String[] args) {
        String s = "abab";
        Trie4 obj = new Trie4();
		for(int indx = 0; indx < s.length(); indx++){
			obj.insert(s.substring(indx));
		}
		System.out.println(obj.cntstr() + 1);
    }
}
