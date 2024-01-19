package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Three_3Sum {
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1(nums));
    }
    //1st Approach: Using two pointers [Optimal]
    public static List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
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
                if(res < 0)
                     j++;
                 else if(res > 0)
                     k--;
                 else
                 {
                     List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                     ans.add(temp);
                     j++;
                     k--;
                     while(j < k && nums[j] == nums[j-1]) j++;
                     while(j < k && nums[k] == nums[k+1]) k--;
                 }
            }
        }
        return ans;
     }
    //2nd Approach: Using Hashing [Better]
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            HashSet<Integer> set1 = new HashSet<>();

            for(int j=i+1; j<n; j++)
            {
                int rem = -(nums[i] + nums[j]);
                if(set1.contains(rem))
                {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], rem));
                    Collections.sort(temp);
                    set2.add(temp);
                }
                set1.add(nums[j]);
            }
        }
        for(List<Integer> list : set2)
            ans.add(list);

        return ans;
    }
}
