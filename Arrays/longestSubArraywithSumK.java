package Arrays;

import java.util.HashMap;

public class longestSubArraywithSumK {
    
    public static void main(String[] args) {
        int A[] = {10, 5, 2, 7, 1, 9};
        int K = 15;
        System.out.println(lenOfLongSubarr(A, A.length, K));
    }
    //1st Approach: Using Hashing [works on both positive & negative numbers]
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int preSum = 0, maxLen = 0;
        for(int i=0; i<A.length; i++)
        {
            preSum += A[i];
            if(preSum == K)
                maxLen = Math.max(maxLen, i+1);
            
            int rem  = preSum - K;
            if(map.containsKey(rem))
                maxLen = Math.max(maxLen, i-map.get(rem));
                
            if(!map.containsKey(preSum))
                map.put(preSum, i);
        }
        return maxLen;
    }
    //2nd Approach: Using Two-Pointer [works only on positive and contains 0 numbers]
    public static int lenOfLongSubarr2(int A[], int N, int K) {
        int left = 0, right = 0, sum = A[0], maxLen = 0;
        
        while(right < N)
        {
            while(left<= right && sum > K)
            {
                sum -= A[left];
                left++;
            }
            if(sum == K)
              maxLen = Math.max(maxLen, right-left+1);
              
            right++;
            if(right < N)
                sum += A[right];
             
        }
        return maxLen;
    }
}
