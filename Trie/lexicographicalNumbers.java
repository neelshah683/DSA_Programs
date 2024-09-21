
package Trie;
import java.util.*;

class TrieNodeLexico{
    TrieNodeLexico[] links = new TrieNodeLexico[10];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch-'0'] != null;
    }
    void put(char ch, TrieNodeLexico newNode){
        links[ch-'0'] = newNode;
    }
    TrieNodeLexico get(char ch){
        return links[ch-'0'];
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
}
class TrieLexico {

    TrieNodeLexico root;
    public TrieLexico() {
        root = new TrieNodeLexico();
    }
    
    public void insert(String word) {
        TrieNodeLexico node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new TrieNodeLexico());
            node = node.get(ch);
        }
        node.setEnd();
    }

    public void dfs(List<Integer> res, int currValue, TrieNodeLexico root){
        if(root == null)    return;

        if(root.isEnd() == true)
            res.add(currValue);

        for(char ch = '0'; ch <= '9'; ch++){
            if(root.containsKey(ch))
                dfs(res, currValue * 10 + (ch - '0'), root.get(ch));
        }
    }
    
}
public class lexicographicalNumbers {
    
    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }
    public static List<Integer> lexicalOrder(int n) {
        TrieLexico obj = new TrieLexico();
    
        // TC: O(N * LogN) | SC: O(N * LogN) -------> 3rd Approach
        for(int indx = 1; indx <= n; indx++)
            obj.insert(Integer.toString(indx));

        List<Integer> res = new ArrayList<>();

        //TC: O(N * LogN) | SC: O(N * LogN)
        obj.dfs(res, 0, obj.root);

        //Overall TC: O(N * LogN) | SC: O(N * LogN)
        return res;
        
        // // TC: O(N) SC: O(1) --------> 2nd Approach

        // List<Integer> res = new ArrayList<>();
        // int num = 1;
        // res.add(num);

        // for(int indx = 1; indx < n; indx++){
        //     if(num * 10 > n){
        //         if(num == n)    num /= 10;
        //         num++;
        //         while(num % 10 == 0)   num /= 10;
        //     }
        //     else    num *= 10;
        //     res.add(num);
        // }

        // return res;

        //1st Approach
        //Brute Force Solution: TC: O(N + NLogN) SC: O(1) exclude return space 
        // List<Integer> res = new ArrayList<>();
        // for(int indx = 1; indx <= n; indx++)
        //     res.add(indx);
        // Collections.sort(res, (a,b) -> (Integer.toString(a).compareTo(Integer.toString(b))));

        // return res;
    }
}
