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
        return atLeastK(nums, k) - atLeastK(nums, k + 1);
    }

    public static long atLeastK(int[] nums, int k) {
        long ans = 0;
        int[] temp = new int[32];

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            for (int i = 0; i < 32; i++) {
                if ((1 << i & nums[r]) != 0) {
                    temp[i]++;
                }
            }

            while ((r - l + 1) > 0 && calc(temp, r - l + 1) < k) {
                for (int i = 0; i < 32; i++) {
                    if ((1 << i & nums[l]) != 0) {
                        temp[i]--;
                    }
                }
                l++;
            }
            ans += (r - l + 1);
        }

        return ans;
}

    public static int calc(int[] temp, int w) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (temp[i] == w) {
                ans += (1 << i);
            }
        }

        return ans;
    }
    /* Another Approach 
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
    }*/
}
