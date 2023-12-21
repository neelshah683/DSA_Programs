package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutationIntArray {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<>();
        boolean[] f = new boolean[nums.length];
        System.out.println(permute(nums, list, temp, f));
    }
    public static List<List<Integer>> permute( int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] f) {

        if(temp.size() == nums.length)
            list.add(new ArrayList<>(temp));

        for(int i=0; i<nums.length; i++)
        {
            if(f[i]==false){
                f[i] = true;
                temp.add(nums[i]);
                permute(nums, list, temp, f);
                temp.remove(temp.size()-1);
                f[i] = false;
            }
        }
        return list;
        
    }
}
