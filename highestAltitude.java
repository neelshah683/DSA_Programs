import java.util.Arrays;

public class highestAltitude {
    
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};

        int currVal = 0, max = 0;
        for(int i=0; i<gain.length;i++)
        {
            currVal = currVal + gain[i];
            max = Math.max(currVal, max);
        }
        System.out.println(max);
        // System.out.println(highAltitude(gain, n));
    }
    public static int highAltitude(int[] gain, int n)
    {
        int[] nums = new int[n+1];
        nums[0] = 0;
        int max = 0;
        for(int i=0; i<nums.length-1; i++)
        {
           nums[i+1] = nums[i] + gain[i];   
            if(nums[i+1] > max)
                max = nums[i+1];
        }
        return max;
    }
}
