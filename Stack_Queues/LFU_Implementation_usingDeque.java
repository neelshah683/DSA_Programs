package Stack_Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class PairMap{
    int val, freq;
    PairMap(int val, int fre){
        this.val = val;
        this.freq = fre;
    }
}
public class LFU_Implementation_usingDeque {
    
    static int iniCap = 0, leastFreq = 0;
    static HashMap<Integer, PairMap> map = new HashMap<>();
    static HashMap<Integer, Deque> freqMap = new HashMap<>();
    public LFU_Implementation_usingDeque(int capacity) {
        this.iniCap = capacity;
    }
    public static void main(String[] args) {
        LFU_Implementation_usingDeque l1 = new LFU_Implementation_usingDeque(3);
        l1.put(1, 10);
        l1.put(2, 20);
        l1.put(3, 30);
        l1.put(4, 40);
        System.out.println(l1.get(3));
        System.out.println(l1.get(2));
        System.out.println(l1.get(4));
        l1.put(5, 50);
        l1.put(2, 25);

    }
    
    
    public static int get(int key) {
        if(!map.containsKey(key)) return -1;

        int val = map.get(key).val;
        int frq = map.get(key).freq;

        freqMap.get(frq).remove(key);

        if(frq == leastFreq && freqMap.get(frq).size() == 0)
            leastFreq++;

        if(!freqMap.containsKey(frq + 1))
            freqMap.put(frq + 1, new ArrayDeque<>());

        freqMap.get(frq + 1).addFirst(key);
        map.get(key).freq = frq + 1;
        return val;
    }
    
    public static void put(int key, int value) {
        if(map.keySet().size() < iniCap){
            if(map.containsKey(key)){
                get(key);
                int currFrq = map.get(key).freq;
                map.put(key, new PairMap(value, currFrq));
            }
            else {
                map.put(key, new PairMap(value, 1));
                if(!freqMap.containsKey(1))
                    freqMap.put(1, new ArrayDeque<Integer>());
                freqMap.get(1).addFirst(key);
                leastFreq = 1;
            }
        }
        else{
            if(map.containsKey(key)){
                get(key);
                int currFrq = map.get(key).freq;
                map.put(key, new PairMap(value, currFrq));
            }
            else{
                map.remove(freqMap.get(leastFreq).pollLast());
                map.put(key, new PairMap(value, 1));
                leastFreq = 1;
                freqMap.get(leastFreq).addFirst(key);
            }
        }
    }
    
}
