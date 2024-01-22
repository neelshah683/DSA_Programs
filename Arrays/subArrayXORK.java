package Arrays;

import java.util.HashMap;

public class subArrayXORK {
    
    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(solve(nums, k));
    }
    public static int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = A.length, xr = 0, cnt = 0;
        map.put(0, 1);
        for(int i=0; i<n; i++)
        {
            xr ^= A[i];
            
            int rem = xr ^ B;
            
            cnt += map.getOrDefault(rem, 0);
            
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return cnt;
    }
}
