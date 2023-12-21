package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class frogJump2 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,8,9,11};
        System.out.println(frogJumpStone(arr));
    }
    public static boolean frogJumpStone(int[] nums)
    {
        int len = nums.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int n : nums)
            map.put(n, new HashSet<Integer>());

        map.get(0).add(1);

        for(int i=0; i<len; i++)
        {
            int currStone = nums[i];
            for(int n : map.get(currStone))
            {
                int pos = currStone + n;
                if(pos == nums[len-1])
                    return true;
                if(map.containsKey(pos))
                {
                    if(n-1 > 0)
                        map.get(pos).add(n-1);
                    map.get(pos).add(n);
                    map.get(pos).add(n+1);
                }
            }
        }
        return false;
    }
}
