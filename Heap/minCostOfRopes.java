package Heap;

import java.util.PriorityQueue;

public class minCostOfRopes {
    public static void main(String[] args) {
        long[] arr = {4, 3, 2, 6};
        int n = arr.length;
        System.out.println(minCost(arr,n));
    }
    public static long minCost(long arr[], int n) 
    {
        if(n == 1) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long val : arr)
            pq.add(val);
        long res = 0;
        while(pq.size() >= 2){
            long num1 = pq.poll();
            long num2 = pq.poll();
            res += (num1 + num2);
            pq.add(num1 + num2);
        }

        return res;
    }
}
