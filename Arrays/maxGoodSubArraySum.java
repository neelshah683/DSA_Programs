package Arrays;

import java.util.HashMap;

public class maxGoodSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-1,3,2,4,5};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long preSum = nums[0], maxi = Long.MIN_VALUE;
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(nums[0], 0L);
        for(int i=1; i<n; i++)
        {
            preSum += nums[i];

            int chk = nums[i] + k;

            if(map.containsKey(chk))
                maxi = Math.max(maxi, preSum-map.get(chk));

            chk = nums[i] - k;

            if(map.containsKey(chk))            
                maxi = Math.max(maxi, preSum-map.get(chk));
            
            map.put(nums[i], Math.min(map.getOrDefault(nums[i], Long.MAX_VALUE),preSum-nums[i]));
        }
        return maxi==Long.MIN_VALUE ? 0 : maxi;
    }
}
