package TwoPointers_SlidingWindow;

public class cntNiceSubArrays {
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int cnt = 0, oddCnt = 0;
        int len = nums.length, res = 0;
        int left = 0;
        for(int right = 0; right < len; right++){
            if(nums[right] % 2 == 1){
                oddCnt++;
                cnt = 0;
            }
            while(oddCnt == k){
                if(nums[left] % 2 == 1) oddCnt--;
                cnt++;
                left++;
            }
            res += cnt;
        }
        return res;
    }
}
