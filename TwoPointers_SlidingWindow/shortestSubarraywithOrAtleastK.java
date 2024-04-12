package TwoPointers_SlidingWindow;


public class shortestSubarraywithOrAtleastK {
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 8, 5, 7, 3};
        int k = 15;
        System.out.println(minimumSubarrayLength(nums, k));
    }
    public static int minimumSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int indx = 0; indx < len; indx++){
            int orNum = 0;
            for(int indx2 = indx; indx2 < len; indx2++){
                orNum |= nums[indx2];
                if(orNum >= k)
                    ans = Math.min(ans, indx2 - indx + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
