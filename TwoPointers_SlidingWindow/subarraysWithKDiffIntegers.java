package TwoPointers_SlidingWindow;

public class subarraysWithKDiffIntegers {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKSubArrays(nums, k) - atMostKSubArrays(nums, k-1);
    }
    public static int atMostKSubArrays(int[] nums, int k) {
        int cntSubArr = 0, cntChars = 0;
        int len = nums.length;
        int left = 0;
        int[] count = new int[30000];
        for(int right = 0; right < len; right++){
            if(count[nums[right]] == 0)
                cntChars++;
            
            while(cntChars > k && left <= right){
                count[nums[left]]--;
                if(count[nums[left]] == 0)
                        cntChars--;
                left++;
            }
            count[nums[right]]++;
            cntSubArr += (right - left + 1);
        }                
        return cntSubArr;
    }
}
