package Arrays;

import java.util.ArrayList;
import java.util.List;

public class majorityElement2 {
    
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length, cnt1 = 0, cnt2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            if(cnt1 == 0 && nums[i] != el2)
            {
                cnt1 = 1;
                el1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != el1)
            {
                cnt2 = 1;
                el2 = nums[i];
            }
            else if(nums[i] == el1)
                cnt1++;
            else if(nums[i] == el2)
                cnt2++;
            else
            {
                cnt1--;
                cnt2--;
            }    
        }
        List<Integer> list = new ArrayList<>();
        int ct1 = 0, ct2 = 0;
        for(int var : nums)
        {
           if(el1 == var)
                ct1++;
            if(el2 == var)
                ct2++; 
        }
            

        int chk = (n/3) + 1;

        if(ct1 >= chk)
            list.add(el1);
        if(ct2 >= chk) 
            list.add(el2);    

        return list;
    }
}
