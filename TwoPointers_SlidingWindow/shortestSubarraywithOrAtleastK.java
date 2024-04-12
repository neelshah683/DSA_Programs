package TwoPointers_SlidingWindow;

public class shortestSubarraywithOrAtleastK {
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 8, 5, 7, 3};
        int k = 15;
        System.out.println(minimumSubarrayLength(nums, k));
    }
    public static int minimumSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int orNum = 0;
        int ans = Integer.MAX_VALUE;
        for(int right = 0; right < len; right++){
            orNum |= nums[right];
            while(orNum >= k && left <= right){
                ans = Math.min(ans, right - left + 1);
                orNum -= nums[left];
                left++;
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
