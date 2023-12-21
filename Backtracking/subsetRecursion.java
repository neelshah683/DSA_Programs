package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetRecursion {
    
        public static void main(String[] args) {
            int[] nums = {1, 2, 2};
            // Arrays.sort(nums);
            List<List<Integer>> al = subsets(nums);
            System.out.println((al));
        }
        public static List<List<Integer>> subsets(int[] nums) 
        {
            List<List<Integer>> list = new ArrayList<>();
            backtrack(list, new ArrayList<Integer>(),nums, 0);
            return list;
            
        }
        public static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, int index) {
            
            list.add(new ArrayList<>(temp));
            for(int i=index; i < nums.length; i++)
            {
                if(i!=index && nums[i] == nums[i-1])
                    continue;
                temp.add(nums[i]);
                backtrack(list, temp, nums, i+1);
                temp.remove(temp.size()-1);
            }
        }
}
