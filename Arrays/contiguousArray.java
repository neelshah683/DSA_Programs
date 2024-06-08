package Arrays;

import java.util.HashMap;

public class contiguousArray {
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 0, 1, 0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int prefixSum = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int indx = 0; indx < n; indx++){
            prefixSum += (nums[indx] == 1) ? 1 : -1;

            if(map.containsKey(prefixSum))
                maxLen = Math.max(maxLen, indx-map.get(prefixSum));
            else
                map.put(prefixSum, indx);
        }
        return maxLen;
    }
}
