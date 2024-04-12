package TwoPointers_SlidingWindow;

public class shortestSubarraywithOrAtleastK_II {
    
    public static void main(String[] args) {
        int[] nums = {2, 1, 8, 5, 7, 3};
        int k = 15;
        System.out.println(minimumSubarrayLength(nums, k));
    }
    public static int minimumSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int[] bits = new int[32];

        for(int right = 0; right < len; right++){

            addBits(nums[right], bits);

            while(getValue(bits) >= k && left <= right){
                ans = Math.min(ans, right - left + 1);
                subBits(nums[left], bits);
                left++;
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    public static void addBits(int num, int[] bits){
        for(int indx = 31; indx >= 0; indx--){
            bits[indx] += (num & 1);
            num >>= 1;
        }
    }
    public static void subBits(int num, int[] bits){
        for(int indx = 31; indx >= 0; indx--){
            bits[indx] -= (num & 1);
            num >>= 1;
        }
    }
    public static int getValue(int[] bits){
        int pow = 0, value = 0;
        for(int indx = 31; indx >= 0; indx--){
            if(bits[indx] != 0)
                value += Math.pow(2, pow);
            pow++;
        }
        return value;
    }
}
