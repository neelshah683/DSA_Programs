package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class countPairsDistance_K {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int k = 5;        
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(4, 2));
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(5, 2));
        System.out.println(countPairs(list, k));
    }
    public static int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int count = 0;

        for(List<Integer> list : coordinates)
        {
          int x1 = list.get(0);
          int y1 = list.get(1);
          for(int i=0; i<=k; i++)
          {
            int x2 = i^x1;
            int y2 = (k-i)^y1;
            if(map.containsKey(new Pair(x2, y2)))
              count += map.get(new Pair(x2, y2));
          }
          map.put(new Pair(x1, y1), map.get(new Pair(x1,y1))+1);
        }
        return count;
    }
}
