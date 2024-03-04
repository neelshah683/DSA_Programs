package Heap;

import java.util.PriorityQueue;

public class kthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        if(nums.length < k) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));

        for(int val : nums)
            pq.add(val);
        
        while(!pq.isEmpty() && k > 1){
            pq.poll();
            k--;
        } 
        return pq.peek();
    }
}
