package Arrays;

import java.util.HashMap;

public class continuousSubArraySum {
    
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int indx = 0; indx < n; indx++){
            prefixSum = (prefixSum + nums[indx]) % k;
            if(map.containsKey(prefixSum)){
                if((indx - map.get(prefixSum)) >= 2)
                    return true;
            }
            else
                map.put(prefixSum, indx);
        }
        return false;
    }
}
