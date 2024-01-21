package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Three_3Sum_Closet {
    
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest1(nums, target));
    }
    //1st Approach: Using Two Pointers TC: O(N^2) SC: O(1)
    public static int threeSumClosest1(int[] nums, int target) {
        int n = nums.length, maxi = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
       for(int i=0; i<n; i++)
       {
           if(i > 0 && nums[i] == nums[i-1])
                continue;

           int j = i+1;
           int k = n-1;
           while(j < k)
           {
               int res = nums[i] + nums[j] + nums[k];
               if(res < target)
               {
                    j++;
               }
                else if(res > target)
                {
                    k--;
                }
                else
                {
                    return target;
                }
                
                int str = Math.abs(res-target);
                if(str < ans)
                {
                    ans = str;
                    maxi = res;
                }
           }
       } 
       return maxi;
    }
    //2nd Approach: Using Hashing TC: O(N^2) + O(N) SC: O(N)
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
       List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);
       for(int i=0; i<n; i++)
       {
           if(i > 0 && nums[i] == nums[i-1])
                continue;

           int j = i+1;
           int k = n-1;
           while(j < k)
           {
               int res = nums[i] + nums[j] + nums[k];
               if(res < target)
               {
                    j++;
               }
                else if(res > target)
                {
                    k--;
                }
                else
                {
                    return target;
                }
                map.put(res, Math.abs(res-target));
           }
       } 
       int mxi = Integer.MAX_VALUE, ret = 0;      
        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            if(e.getValue() < mxi)
            {
                mxi = e.getValue();
                ret = e.getKey();
            }
        }
       return ret;
    }
}
