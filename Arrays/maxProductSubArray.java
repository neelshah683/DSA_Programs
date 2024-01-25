package Arrays;

public class maxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int prod = 1, suff = 1, maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            if(prod == 0)
                prod = 1;
            if(suff == 0)   
                suff = 1;
            prod *= nums[i];
            suff *= nums[n-i-1];
            maxi = Math.max(maxi, Math.max(prod, suff));
        }
        return maxi;
    }
}
