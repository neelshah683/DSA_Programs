package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

import Arrays.countGloLocInversions;

public class divideChocolates {
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(getMaximumSweetness(arr, 3));
    }
    public static int getMaximumSweetness(ArrayList<Integer> arr, int k) {
		int low = 1, high = returnMaxSum(arr);
		while(low <= high)
		{
			int mid = low + (high-low) / 2;
			if(chkPossible(arr, mid, k)==true)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return high;
	}
	public static int returnMaxSum(ArrayList<Integer> list)
	{
		int maxi = 0;
		for(int var: list)
			maxi += var;
		return maxi;
	}
	public static boolean chkPossible(ArrayList<Integer> list, int mid, int k)
	{
		int sum = 0, chunk = 0;

		for(int var: list)
		{
			sum += var;
			if(sum >= mid)
			{
				chunk++;
				sum = 0;
			}
		}
		return chunk >= k+1;
	}
}
