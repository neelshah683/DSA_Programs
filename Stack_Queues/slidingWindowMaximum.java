package Stack_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class slidingWindowMaximum {
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k  = 3;
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
    }
    //TC: O(N) SC: O(N)
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length, ini = 0;
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int index = 0; index < len; index++){
            if(!dq.isEmpty() && dq.peek() == index - k) dq.poll();

            while(!dq.isEmpty() && nums[index] > nums[dq.peekLast()])
                dq.pollLast();

            dq.offer(index);

            if(index >= k - 1) res[ini++] = nums[dq.peek()];
        }
        return res;
    }
    //TC: O(NLogK) SC: O(K)
    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     int len = nums.length;
    //     int[] res = new int[len - k + 1];
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (nums[b] - nums[a]));

    //     for(int index = 0; index < len; index++){
    //         int indVal = index - k;

    //         if(indVal >= 0)
    //             pq.remove(indVal);

    //         pq.add(index);

    //         if(pq.size() == k)
    //             res[index - k + 1] = nums[pq.peek()];
    //     }
    //     return res;
    // }
}
