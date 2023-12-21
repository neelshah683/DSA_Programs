import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class singleNumber2 {
    
    public static void main(String[] args) {
        int [] nums = {1,2,1,3,2,5};
       
        System.out.println(Arrays.toString(singleNum(nums)));
    }
    public static int[] singleNum(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        List<Integer> al = new ArrayList<>();

        for(int key : map.keySet())
            if(map.get(key)==1)
            {
                al.add(key);
            }

        int[] arr = new int[al.size()];

        for(int i=0; i<al.size(); i++)
            arr[i] = al.get(i);
            
        return arr;
        }
}
