package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class four_4sum {
    
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum1(arr, 0));
    }
    //1st Approach: Using Two pointers TC: O(N^3) 
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<n; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n; j++)
            {
                if( j > i+1 && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;

                while(k < l)
                {
                    long res = nums[i] + nums[j];
                    res += nums[k];
                    res += nums[l];
                    if(res > target)
                        l--;
                    else if(res < target)
                        k++;
                    else
                    {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        list.add(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return list;
    }
    //2nd Approach: Using Hashing TC: O(N^3) SC: O(N) + O(quads) * 2
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> set2 = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n-2; i++)
        {
            for(int j=i+1; j<n-1; j++)
            {
                HashSet<Long> set1 = new HashSet<>();

                for(int k=j+1; k<n; k++)
                {
                    long rem = (nums[i] + nums[j]);
                    rem += nums[k];
                    long res = target - rem;
                    if(set1.contains(res))
                    {
                       List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], (int) res));
                        Collections.sort(temp);
                        set2.add(temp);
                    }
                    set1.add((long)nums[k]);
                }
            }
        }
        for(List<Integer> ans : set2)
            list.add(ans);
        return list;
    }
}
