package Heap;
import java.util.*;
class KthLargest {

    PriorityQueue<Integer> pq;
    int capacity = 0;
    public KthLargest(int k, int[] nums) {
       pq = new PriorityQueue<>();
       this.capacity = k;
       for(int val : nums){
            if(pq.size() < capacity)
                pq.add(val);
            else if(pq.size() == capacity){
                if(val > pq.peek()){
                    pq.poll();
                    pq.add(val);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < capacity){
            pq.add(val);
            return pq.peek();
        }

        int retEle = pq.peek();

        if(val > retEle){
            pq.poll();
            pq.add(val);
            retEle = pq.peek();
        }
        
        return retEle;
    }
}
public class kthLargeElementStream {
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargest k1 = new KthLargest(k, nums);
        System.out.println(k1.add(3));
        System.out.println(k1.add(5));
        System.out.println(k1.add(10));
        System.out.println(k1.add(9));
        System.out.println(k1.add(4));

    }
}
