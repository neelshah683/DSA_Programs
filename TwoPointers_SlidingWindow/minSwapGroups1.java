package TwoPointers_SlidingWindow;

public class minSwapGroups1 {
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1};
        System.out.println(minSwaps(nums));
    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        for(int indx = 0; indx < n; indx++){
            if(nums[indx] == 1)
                cnt++;
        }
        if(cnt == n)    return 0;
        if(cnt == 0)    return -1;

        int[] nums2 = new int[n * 2];
        int n2 = nums2.length;

        for(int indx = 0; indx < n2; indx++)
            nums2[indx] = nums[indx % n];
            
        //sliding window intuition
        int left = 0,minSwap = 0, cnt2 = 0; 
        int ans = Integer.MAX_VALUE; 

        for(int right = 0; right < n; right++){
            if(nums2[right] == 0)
                minSwap++;
                
            cnt2++;
            if(cnt2 == cnt)
                ans = Math.min(ans, minSwap);
            
            if(cnt2 > cnt){
                cnt2--;
                if(nums2[left] == 0)
                    minSwap--;
                left++;
                
                if(cnt2 == cnt)
                    ans = Math.min(ans, minSwap);
            }
        }
        return ans;
    }
}
