import java.util.ArrayList;
import java.util.List;

public class powerSet {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int index = 0; index < (1 << len); index++)
        {
            List<Integer> temp = new ArrayList<>();
            for(int index2 = 0; index2 < len; index2++)
            {
                //this can also be written as: if((index & (1 << index2)) > 0)
                if(((index >> index2) & 1)==1)
                    temp.add(nums[index2]);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
