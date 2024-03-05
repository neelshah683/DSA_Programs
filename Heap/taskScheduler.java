package Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class PairFreq{
    int key, val;
    PairFreq(int k, int v){
        this.key = k;
        this.val = v;
    }
}

public class taskScheduler {
    
    public static void main(String[] args) {
        char[] ch = {'A','C','A','B','D','B'};
        int n = 1;
        System.out.println(leastInterval(ch, n));
    }
     public static int leastInterval(char[] tasks, int n) {
       Queue<PairFreq> q = new LinkedList<>();
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
       HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : tasks) 
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        pq.addAll(map.values());

        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){

            time++;

            if(!pq.isEmpty()){
                int cnt = pq.poll() - 1;
                if(cnt != 0)    q.add(new PairFreq(cnt, time + n));
            }
            
            if(!q.isEmpty() && q.peek().val == time)
                pq.add(q.poll().key);
        }
        return time;
    }
}
