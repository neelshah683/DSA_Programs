package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Arrays.sort(nums);
        int target = 8;
        List<List<Integer>> list = new ArrayList<>();
        combineSum(nums, 0, list, new ArrayList<Integer>(), target);
        System.out.println(list);
    }
    public static void combineSum(int[] nums, int index, List<List<Integer>> list, ArrayList<Integer> temp, int target)
    {
        if(target == 0)
            list.add(new ArrayList<>(temp));
        
        for(int i=index; i<nums.length;i++)
        {
            if(nums[i] > target)
                return; 
            temp.add(nums[i]);
            combineSum(nums, i, list, temp, target-nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}
