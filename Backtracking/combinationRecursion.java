package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationRecursion {
    
    public static void main(String[] args) {
        int k = 4;
        int[] nums = {10,9,2,5,3,7,101,18};
        List<List<Integer>> list = new ArrayList<>();
        combineRecur(nums, k, 0, list, new ArrayList<Integer>());
        System.out.println(list);
    }
    public static void combineRecur(int[] nums, int k, int index, List<List<Integer>> list, ArrayList<Integer> temp)
    {
        if(temp.size() == k)
            list.add(new ArrayList<>(temp));
        for(int i=index; i<nums.length; i++)
        {
            temp.add(nums[i]);
            combineRecur(nums, k, i+1, list, temp);
            temp.remove(temp.size()-1);
        }
    }
}
