package Heap.Queue;

import java.util.PriorityQueue;

public class maxThresholdValue {
    public static void main(String[] args) {
        int [] nums = {97,24,43,45,45,26};
        int k = 45;
        System.out.println(minOperations(nums, k));
    }
    
    public static int minOperations(int[] nums, int k) {
        if(nums.length == 1) return 0;
        
         PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add((long)num);
        }

        int operations = 0;

        while (pq.peek() < k && pq.size() >= 2) {
            long x = pq.poll();
            long y = pq.poll();

            long newNum = Math.min(x,y) * 2 + Math.max(x,y);
            pq.add(newNum);
            operations++;
        }


        return operations;
    }
}
