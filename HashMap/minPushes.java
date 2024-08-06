package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * minPushes
 */
public class minPushes {

    public static void main(String[] args) {
        String word = "abcde";
        System.out.println(minimumPushes(word));
    }
     public static int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> 
            (map.get(b) - map.get(a)));

        for(char ch: word.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        pq.addAll(map.keySet());

        int ans = 0, cnt = 0;
        while(!pq.isEmpty()){
            char key = pq.poll();
            ans += map.get(key) * (cnt / 8 + 1);            
            cnt++;
        }

        return ans;
    }
}