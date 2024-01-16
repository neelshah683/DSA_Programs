package Arrays;

import java.util.Arrays;

public class nextPermutation {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int ind = -1, n = nums.length;
        for(int i=n-2; i>=0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                ind = i;
                break;
            }
        }
        if(ind == -1)
        {
            revArr(nums, 0, n-1);
            return ;
        }
        for(int i=n-1; i>ind; i--)
        {
            if(nums[i] > nums[ind])
            {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        revArr(nums, ind+1, n-1);
    }
    public static void revArr(int[] nums, int start, int end)
    {
        while(start <= end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
