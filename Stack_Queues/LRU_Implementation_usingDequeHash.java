package Stack_Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class LRU_Implementation_usingDequeHash {
    
    static int iniCap = 0;
    static Deque<Integer> q;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) {
        LRU_Implementation_usingDequeHash l1 = new LRU_Implementation_usingDequeHash(2);
        l1.put(1, 1);
        l1.put(2, 2);
        System.out.println(l1.get(1));
        l1.put(3, 3);
        System.out.println(l1.get(2));
        l1.put(4, 4);
        System.out.println(l1.get(1));
        System.out.println(l1.get(3));
        System.out.println(l1.get(4));
    }
    public LRU_Implementation_usingDequeHash(int capacity) {
        this.iniCap = capacity;
        q = new ArrayDeque<>();
        map = new HashMap<>();
    }
    
    public static int get(int key) {
        if(map.containsKey(key)){
            q.remove(key);
            q.addFirst(key);
            return map.get(key);
        }
        return -1;
    }
    
    public static void put(int key, int value) {
        if(map.containsKey(key))
            q.remove(key);
        else{
            if(q.size() >= iniCap)
                map.remove(q.pollLast());            
        }
        q.addFirst(key);
        map.put(key, value);        
    }
}
