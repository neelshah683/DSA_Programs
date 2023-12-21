package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class longestIncreasingSubsequence {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        int len = arr.length;
        int[][] dp = new int[len+1][len+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        System.out.println(incrSubseq(arr, dp, 0, -1));
        System.out.println(incrSubseq2(arr));
        System.out.println(incrSubseq3(arr));
        System.out.println(incrSubseq4(arr));
        System.out.println(incrSubseq5(arr));

    }
    public static int incrSubseq(int[] nums, int[][] dp, int index, int prevIndex)
    {
        if(index == nums.length)
            return 0;
        if(dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];
            
        int nonPick = incrSubseq(nums, dp, index+1, prevIndex);
        int pick = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex])
            pick = 1 + incrSubseq(nums, dp, index+1, index);

         return dp[index][prevIndex+1] = Math.max(nonPick, pick);   
    }
     public static int incrSubseq2(int[] nums)
    {
        int len = nums.length;
        int[][] dp = new int[len+1][len+1];
        
        for(int i=len-1; i>=0; i--)
        {
            for(int j=i-1; j>=-1; j--)
            {
                    int nonPick = dp[i+1][j+1];
                    int pick = 0;
                    if(j == -1 || nums[i] > nums[j])
                        pick = 1 + dp[i+1][i+1];

                   dp[i][j+1] = Math.max(nonPick, pick);
            }
        }          
        return dp[0][0];   
    }
    public static int incrSubseq3(int[] nums)
    {
        int len = nums.length;
        int[] prev = new int[len+1];
        int[] curr = new int[len+1];
        
        for(int i=len-1; i>=0; i--)
        {
            for(int j=i-1; j>=-1; j--)
            {
                    int nonPick = prev[j+1];
                    int pick = 0;
                    if(j == -1 || nums[i] > nums[j])
                        pick = 1 + prev[i+1];

                   curr[j+1] = Math.max(nonPick, pick);
            }
            prev = curr;
        }          
        return prev[0];   
    }
    //Another Approach
    public static int incrSubseq4(int[] nums)
    {
        int len = nums.length, maxi = 1;
        int[] dp = new int[len];  
        Arrays.fill(dp, 1);

        for(int i=0; i<len; i++)
        {
            for(int prev=0; prev<i; prev++)
            {
                if(nums[prev] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
            maxi = Math.max(maxi, dp[i]);
        }          
        return maxi;   
    }
    //print LIS
    public static ArrayList<Integer> incrSubseq5(int[] nums)
    {
        int len = nums.length, maxi = 1, lastIndex = 0;
        int[] dp = new int[len];
        int[] hash = new int[len];  
        Arrays.fill(dp, 1);
             
        for(int i=0; i<len; i++)
        {
            hash[i] = i;
            for(int prev=0; prev<i; prev++)
            {
                if( nums[prev] < nums[i] && 1+dp[prev] > dp[i])
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex)
        {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);

        }
        Collections.reverse(list); 
        return list;  
    }
}
