package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class TrieNode6{
    TrieNode6[] links = new TrieNode6[2];

    boolean containsKey(int bit){
        return links[bit] != null;
    }
    TrieNode6 get(int bit){
        return links[bit];
    }
    void put(int bit, TrieNode6 newNode){
        links[bit] = newNode;
    }
}
class Trie6{
    TrieNode6 root;
    Trie6(){
        root = new TrieNode6();
    }
    public void insert(int num){
        TrieNode6 node = root;
        for(int bitNo = 31; bitNo >= 0; bitNo--){
            int bit = (num & (1 << bitNo)) > 0 ? 1 : 0;
            if(!node.containsKey(bit))
                node.put(bit, new TrieNode6());
            node = node.get(bit);
        }
    }
    public int getMax(int num){
        TrieNode6 node = root;
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
public class maxXorElementArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[][] queries = {
            {3, 1},
            {1, 3},
            {5, 6}
        };
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> strQ = new ArrayList<>();
        int ind = 0;

        for(int[] q : queries){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(q[1]);
            temp.add(q[0]);
            temp.add(ind++);
            strQ.add(temp);
        }

        Collections.sort(strQ, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(0).compareTo(b.get(0));
            }
        });

        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int ind2 = 0, n = nums.length;

        Trie6 obj = new Trie6();
        for(int indx = 0; indx < strQ.size(); indx++){
            while(ind2 < n && nums[ind2] <= strQ.get(indx).get(0)){
                obj.insert(nums[ind2]);
                ind2++;
            }
            int qIndex = strQ.get(indx).get(2);
            if(ind2 != 0)
                res[qIndex] = obj.getMax(strQ.get(indx).get(1));
        }
        System.out.println(Arrays.toString(res));
    }
}
