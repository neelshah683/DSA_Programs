package DynamicProgramming;

import java.util.Arrays;

public class longestBitonicSubsequence {
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println(bitonicSubsq(arr));
    }
    public static int bitonicSubsq(int[] nums)
    {
        int len = nums.length, maxi = 1;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i=0; i<len; i++)
        {
            for(int prev = 0; prev<i; prev++)
            {
                if(nums[i] > nums[prev] && 1+dp1[prev]>dp1[i])
                {
                    dp1[i] = 1 + dp1[prev];
                }
            }
            
        }
        for(int i=len-1; i>=0; i--)
        {
            for(int prev = len-1; prev>i; prev--)
            {
                if(nums[i] > nums[prev] && 1+dp2[prev]>dp2[i])
                {
                    dp2[i] = 1 + dp2[prev];
                }
            }
        }    
        for(int i=0; i<len; i++)
        {
            if(dp1[i] > 1 && dp2[i]>1)
                maxi = Math.max(maxi, (dp1[i]+dp2[i])-1);
        }
        return len-maxi;
    }
}
