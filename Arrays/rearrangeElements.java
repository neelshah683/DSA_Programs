package Arrays;

import java.util.Arrays;

public class rearrangeElements {
    
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length, pos = 0, neg = 1;
        int[] res = new int[n];
        for(int i=0; i<n; i++)
        {
            if(nums[i] > 0)
            {
                res[pos] = nums[i];
                pos += 2;
            }
            else
            {
                res[neg] = nums[i];
                neg += 2;
            }
        }
        return res;
    }
}
