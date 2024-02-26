package TwoPointers_SlidingWindow;

import java.util.HashMap;

public class binarySubArraySum {
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum1(nums, goal));
    }
    //TC: O(N) SC: O(1) //Sliding Window + Two Pointers
    public static int numSubarraysWithSum1(int[] nums, int goal) {
        int left = 0, sum = 0, cnt = 0;
        int temp = 0, len = nums.length;

        for(int right = 0; right < len; right++){
            sum += nums[right];
            if(nums[right] == 1) temp = 0;
            if(sum > goal){
                sum -= nums[left];
                left++;
            }
            while(sum == goal && left <= right){
                sum -= nums[left];
                left++;
                temp++;
            }
            cnt += temp;
        }
    return cnt;
    }
    //TC: O(N) SC: O(N) // PrefixSum
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum = 0, cnt = 0;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int index = 0; index < len; index++){
            prefixSum += nums[index];
            int k = prefixSum - goal;
            // cnt += map.getOrDefault(k, 0);
            // map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }
}
