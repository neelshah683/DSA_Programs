package BinarySearch;

import java.util.Arrays;

public class capacityShipPackageswithinDdays {
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 4, 1, 4};
        int days = 3;
        System.out.println(shipWithinDays(nums, days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(chkWeight(weights, mid, days)==true)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high+1;
    }
    public static boolean chkWeight(int[] arr, int capacity, int days)
    {
        int currday = 1, weight = 0;

        for(int var : arr)
        {
            weight += var;
            if(weight > capacity)
            {
                currday++;
                weight = var;
            }
        }
        return (currday <= days) ? true : false;
    }
}
