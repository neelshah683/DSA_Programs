package TwoPointers_SlidingWindow;

public class maxConsecutiveOne {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0;
        int len = nums.length, cntZero = 0;

        for(int right = 0; right < len; right++){
            if(nums[right] == 0)  cntZero++;
            while(cntZero > k){
                if(nums[left] == 0) cntZero--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
