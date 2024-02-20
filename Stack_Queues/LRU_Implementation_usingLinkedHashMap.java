package Stack_Queues;

import java.util.LinkedHashMap;

public class LRU_Implementation_usingLinkedHashMap {
    
    static int iniCap = 0;
    static LinkedHashMap<Integer, Integer> map;
    public LRU_Implementation_usingLinkedHashMap(int capacity) {
        this.iniCap = capacity;
        map = new LinkedHashMap<>();
    }
    //Optimized Version
    public static void main(String[] args) {
        LRU_Implementation_usingLinkedHashMap l1 = new LRU_Implementation_usingLinkedHashMap(2);
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
    public static int get(int key) {
        if(map.containsKey(key)){
            int retVal = map.get(key);
            map.remove(key);
            map.put(key, retVal);
            return retVal;
        }
        return -1;
    }
    
    public static void put(int key, int value) {
        if(map.containsKey(key))
            map.remove(key);
        else if(map.size() == iniCap){
            int firstEntry = map.entrySet().iterator().next().getKey();
            map.remove(firstEntry);
        }
        map.put(key, value);
    }
}
