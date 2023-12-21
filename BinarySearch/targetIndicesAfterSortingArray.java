package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class targetIndicesAfterSortingArray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 8, 8, 8, 8, 8, 9};
        int target = 8;
        Arrays.sort(nums);
        // System.out.println(targetIndices(nums, target, true));
        System.out.println(targetIndices2(nums, target));

    }
    public static List<Integer> targetIndices(int[] nums, int target, boolean startIndex)
    {
        int start = 0, end = nums.length-1;
        List<Integer> list = new ArrayList<>();
        
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(target < nums[mid])
                end = mid - 1;
            else if(target > nums[mid])
                start = mid + 1;
            else{
                list.add(mid);
                if(startIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        Collections.sort(list);
        return list;
    }
    public static List<Integer> targetIndices2(int[] nums, int target)
    {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==target)
                list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}
