package Arrays;

public class maxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int n = nums.length, prod = nums[0], maxi = nums[0];
        for(int i=1; i<n; i++)
        {
            if(prod == 0)
                prod = nums[i];
            else    
                prod *= nums[i];

            if(prod > maxi)
            {
                maxi = prod;
            }    
            else
            {
                prod = 0;

            }
        }
        return maxi;
    }
}
