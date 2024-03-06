package Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class handOfStraights {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(nums, groupSize));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();

        for(int val : hand)
            pq.add(val);
        
        int cnt = 0, prev = -1;
        while(!pq.isEmpty()){
            int val = pq.peek();

            pq.poll();

            if(prev == -1 || val - prev == 1){
                prev = val;
                cnt++;
            }
            else
                q.offer(val);
            
            if(cnt == groupSize){
                cnt = 0;
                prev = -1;

                while(!q.isEmpty())
                    pq.add(q.poll());
            }
        }
        return cnt > 0 ? false : true;
    }
}
