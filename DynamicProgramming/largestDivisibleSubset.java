package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1};
        Arrays.sort(arr);
        System.out.println(largDivSubset(arr));
    }
    public static List<Integer> largDivSubset(int[] nums)
    {
        int len = nums.length, maxi = 1, lastIndex=0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int[] hash = new int[len];
        
        for(int i=0; i<len; i++)
        {
            hash[i] = i;
            for(int prev = 0; prev<i; prev++)
            {
                if((nums[i]%nums[prev]==0 || nums[prev]%nums[i]==0) && 1+dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }

            }
            if(dp[i] > maxi)
            {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();

        list.add(nums[lastIndex]);

        while(hash[lastIndex]!=lastIndex)
        {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
    
}
