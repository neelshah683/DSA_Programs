package DynamicProgramming;
import java.util.*;

public class maxTotalDamageCells {
    
    //TC: O(NlogN) | SC: O(N)
    public static void main(String[] args) {
        int[] power = {7, 1, 6, 6};
        System.out.println(maximumTotalDamage(power));
    }
    public static long maximumTotalDamage(int[] power) {
        TreeMap<Long, Long> treeMap = new TreeMap<>();

        for(int var : power)
            treeMap.put((long)var, treeMap.getOrDefault((long)var, 0L) + 1);
        
        HashMap<Long, Long> dp = new HashMap<>();
        long prevEl = 0, ans = 0, backEl = 0;

        for(Map.Entry<Long, Long> entry : treeMap.entrySet()){
            long el = entry.getKey();
            long val = entry.getValue();

            Map.Entry<Long, Long> backEty = treeMap.lowerEntry(el - 2);

            backEl = (backEty != null) ? backEty.getKey() : 0;

            dp.put(el, Math.max(dp.getOrDefault(prevEl, 0L), el * val + dp.getOrDefault(backEl, 0L)));

            ans = Math.max(ans, dp.get(el));

            prevEl = el;
        }

        return ans;
    }
}
