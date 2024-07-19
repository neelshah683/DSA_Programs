package Arrays;

import java.util.HashMap;
import java.util.Map;

public class subArrAndValueK {
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 3, 2, 1, 2, 3};
        int k = 1;
        System.out.println(countSubarrays(nums, k));
    }
    public static long countSubarrays(int[] nums, int k) {
       int n = nums.length;
        long count = 0;

        Map<Long, Long> prevResults = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            Map<Long, Long> currResults = new HashMap<>();

            if (nums[i] == k) {
                ++count;
            }
            currResults.put((long) nums[i], 1L);

            for (Map.Entry<Long, Long> entry : prevResults.entrySet()) {
                long val = entry.getKey();
                long freq = entry.getValue();

                long newAndResult = val & nums[i];
                if (newAndResult == k) {
                    count += freq;
                }
                currResults.put(newAndResult, currResults.getOrDefault(newAndResult, 0L) + freq);
            }

            prevResults = currResults;
        }

        return count;
    }
}
