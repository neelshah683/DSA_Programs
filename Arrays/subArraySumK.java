
package Arrays;

import java.util.HashMap;

/**
 * subArraySumK
 */
public class subArraySumK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        System.out.println(subarraySum(nums, 3));
    }
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0, cnt = 0;
        int n = nums.length;
        map.put(0,1);
        for(int i=0; i<n; i++)
        {
            preSum += nums[i];

            int remove = preSum - k;

            cnt += map.getOrDefault(remove, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}