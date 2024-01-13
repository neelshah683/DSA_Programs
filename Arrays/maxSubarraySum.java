package Arrays;

import java.util.Arrays;

public class maxSubarraySum {
    
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(Arrays.toString(printSubArray(nums)));
    }
    public static int maxSubArray(int[] nums) {
        int n = nums.length, sum = 0, maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if(sum < 0)
                sum = 0;      
        }
        return maxi;
    }
    public static int[] printSubArray(int[] nums) {
        int n = nums.length, sum = 0, start = 0, ansStart = 0, ansEnd = 0, maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            if(sum == 0)
                start = i;
            sum += nums[i];
            if(sum > maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0)
                sum = 0;      
        }
        int[] result = new int[ansEnd-ansStart+1];
        int x = 0;
        for (int j = ansStart; j <= ansEnd; j++ )
        {
            result[x++] = nums[j];
        }
        return result;
    }
}
