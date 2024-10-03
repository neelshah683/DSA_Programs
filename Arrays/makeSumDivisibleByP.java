package Arrays;

import java.util.HashMap;
import java.util.Map;

public class makeSumDivisibleByP {
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        int k = 6;
        System.out.println(minSubarray(nums, k));
    }
    public static int minSubarray(int[] nums, int p) {
        int sum = 0;
        int n = nums.length;

        //TC: O(N) | SC: O(1)
        for(int val : nums)
            sum = (sum + val) % p;
        
        int target = sum % p;
        if(target == 0)    return 0;

        //edge case: [1,2,3] | p = 3 ---> res = n = 3 , return -1
        int res = n, curr = 0;    

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        //TC: O(N) | SC: O(N)
        for(int indx = 0; indx < n; indx++){
            curr = (curr + nums[indx]) % p;

            int prev = (curr - target + p) % p;
            if(map.containsKey(prev))
                res = Math.min(res, indx - map.get(prev));
            
            map.put(curr, indx);
        }   
        
        //Overall TC: O(N) | SC: O(N)
        return res == n ? -1 : res;
    }
}
