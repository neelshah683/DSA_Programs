package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import HashMap.Pair;


class PairQ{
    int indx, val;
    PairQ(int x, int y){
        this.indx = x;
        this.val = y;
    }
}
public class markElementsbyPerformingQueries {
    
    public static void main(String[] args) {
        int[] nums = {1,12,12,4,14,1,12,1};
        int[][] queries = {
            {1,2},
            {5,4},
            {4,0},
            {0, 1},
            {0, 3}
        };
        System.out.println(Arrays.toString(unmarkedSumArray(nums,queries)));
    }   
    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int len = nums.length;
        List<Long> res = new ArrayList<>();
        boolean[] chk = new boolean[len];
        Arrays.fill(chk, false);

        PriorityQueue<PairQ> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1.val != p2.val) return p1.val - p2.val;
            else    return p1.indx - p2.indx;
        }); 
           long sum = 0;

        for(int index = 0; index < len; index++){
            sum += nums[index];
            pq.add(new PairQ(index, nums[index]));
        }
        int ini = 0;
        for(int[] query : queries){
            if(!chk[query[0]]){
                chk[query[0]] = true;
                sum -= nums[query[0]];
            }
            int cnt = query[1];
            while(cnt > 0 && !pq.isEmpty()){
                PairQ p = pq.poll();
                
                if(!chk[p.indx]){
                    chk[p.indx] = true;
                    sum -= p.val;
                    cnt--;
                }
            }
            res.add(sum);
        }
        long[] ans = new long[res.size()];

        for(long num : res) ans[ini++] = num;

        return ans;
    }
}
