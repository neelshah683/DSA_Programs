package Heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


class PairArrReplace{
    int ele, ind;
    PairArrReplace(int e, int ind){
        this.ele = e;
        this.ind = ind;
    }
}
public class replaceArrayItemsWithCnt {
    public static void main(String[] args) {
        int[] arr = {20, 15, 26, 2, 98, 6};
        int N = arr.length;
        System.out.println(replaceWithRank(arr, N));
    }
    public static int[] replaceWithRank(int arr[], int N) {
        List<Integer> list = new ArrayList<>();
        
        for(int val : arr)
            list.add(val);
            
        PriorityQueue<PairArrReplace> pq = new PriorityQueue<>((a,b) -> a.ele - b.ele);
        
        for(int index = 0; index < N; index++)
            pq.add(new PairArrReplace(list.get(index), index));
            
        int cnt = 0;
        int prevEle = Integer.MIN_VALUE;
        while(!pq.isEmpty()){            
            PairArrReplace curr = pq.poll();
            if(curr.ele != prevEle)
                ++cnt;
            list.set(curr.ind, cnt);  
            prevEle = curr.ele;
        }
        int[] ans = new int[arr.length];
        for(int index = 0; index < N; index++)
            ans[index] = list.get(index);
        return ans;
  }
}
