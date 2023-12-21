import java.util.Arrays;

public class CyclicSort {
    
    public static void main(String[] args) {
         
        int[] arr = {3, 5, 2, 1, 4};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycleSort(int[] nums)
    {
        for(int i=0; i<nums.length;)
        {
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex])
            {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else
                i++;
        }
    }
}
