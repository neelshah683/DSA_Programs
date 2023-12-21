package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationIntArrayDuplicates {
    
    public static void main(String[] args) {
        int[] nums = {3,3,0, 3};
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<>();
        boolean[] f = new boolean[nums.length];
        System.out.println(permuteDuplicates(nums, list, temp, f));
    
    }
    public static List<List<Integer>> permuteDuplicates( int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] f) {

        if(temp.size() == nums.length)
            list.add(new ArrayList<>(temp));

        for(int i=0; i<nums.length; i++)
        {
            if(f[i]==false){
                if(i>0 && f[i-1]!=true && nums[i] == nums[i-1])
                    continue;
                f[i] = true;
                temp.add(nums[i]);
                permuteDuplicates(nums, list, temp, f);
                temp.remove(temp.size()-1);
                f[i] = false;
            }
        }
        return list;
        
    }
}
