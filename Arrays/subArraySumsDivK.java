package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class subArraySumsDivK {
    
    public static void main(String[] args) {
     int[] nums = {4, 5, 0, -2, -3, 1};
     int k = 5;
     System.out.println(subarraysDivByK(nums, k));   
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] prefixSum = new int[n+1];
        for(int indx = 0; indx < n; indx++){
            prefixSum[indx + 1] = (prefixSum[indx] + nums[indx]); 
        }
        System.out.println(Arrays.toString(prefixSum));
        for(int indx = 0; indx < n+1; indx++){
            prefixSum[indx] %= k;
            if(map.containsKey(prefixSum[indx])){
                map.put(prefixSum[indx], map.get(prefixSum[indx]) + 1);
                cnt += map.get(prefixSum[indx]);
            }
            else
                map.put(prefixSum[indx], 0);
        }
        System.out.println(Arrays.toString(prefixSum));

        return cnt;
    }
}
