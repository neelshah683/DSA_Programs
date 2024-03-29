package Trie;

class TrieNode5{
    TrieNode5[] links = new TrieNode5[2];

    boolean containsKey(int bit){
        return links[bit] != null;
    }
    TrieNode5 get(int bit){
        return links[bit];
    }
    void put(int bit, TrieNode5 newNode){
        links[bit] = newNode;
    }
}
class Trie5{
    TrieNode5 root;
    Trie5(){
        root = new TrieNode5();
    }
    void insert(int num){
        TrieNode5 node = root;
        for(int bitNo = 31; bitNo >= 0; bitNo--){
            int bit = (num & (1 << bitNo)) > 0 ? 1 : 0;
            if(!node.containsKey(bit))
                node.put(bit, new TrieNode5());
            node = node.get(bit);
        }
    }
    int getMax(int num){
        TrieNode5 node = root;
        int maxNum = 0;
        for(int bitNo = 31; bitNo >=0; bitNo--){
            int bit = (num & (1 << bitNo)) > 0 ? 1 : 0;
            //it can also be written as: (num >> bitNo) & 1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1 << bitNo);
                node = node.get(1-bit);
            }
            else
                node = node.get(bit);
        }
        return maxNum;
    }
}

public class maxXor_Array {
    
    public static void main(String[] args) {

        int[] nums = {9, 8, 7, 5, 4};

        Trie5 obj = new Trie5();

        for(int val : nums)
            obj.insert(val);
        
        int maxi = 0;
        for(int val : nums){    
           int maxAns =  obj.getMax(val);
           maxi = Math.max(maxi, maxAns);
        }
        System.out.println(maxi);
    }
}
