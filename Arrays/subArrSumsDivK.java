package Arrays;

import java.util.HashMap;

public class subArrSumsDivK {
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }
     public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int[] prefixSum = new int[n+1];
        for(int indx = 0; indx < n; indx++){
            prefixSum[indx + 1] = ((prefixSum[indx] + nums[indx]) % k + k) % k; 
        }
        
        for(int indx = 1; indx < n+1; indx++){
            cnt += map.getOrDefault(prefixSum[indx], 0);
            map.put(prefixSum[indx], map.getOrDefault(prefixSum[indx], 0) + 1);
        }      

        return cnt;
    }
}
