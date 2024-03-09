package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class topKFrequentElements {
    
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent1(nums, k));
    }
    //TC: O(N) SC: O(k)
     public static int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for(int val : nums)
            map.put(val, map.getOrDefault(val, 0) + 1);

        for(int key : map.keySet()){
            int indx = map.get(key);
            if(freq[indx] == null)
                freq[indx] = new ArrayList<>();
            freq[indx].add(key);
        }
        
        int[] res = new int[k];
        List<Integer> storeAns = new ArrayList<>();

        for(int indx = freq.length - 1; indx > 0 && storeAns.size() < k; indx--){
            if(freq[indx] != null){
                storeAns.addAll(freq[indx]);
            }
        }
        int x = 0;
        for(int val : storeAns)
            res[x++] = val;

        return res;
    }
    //TC: O(NLogN) SC: O(N)
     public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : nums)
            map.put(val, map.getOrDefault(val, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(b) - map.get(a)));
        pq.addAll(map.keySet());

        int[] res = new int[k];
        int x = 0;
        while(!pq.isEmpty() && k > 0){
            res[x++] = pq.poll();
            k--;
        }
        return res;
    }
}
