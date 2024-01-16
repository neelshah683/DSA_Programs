package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class longConsecutiveSeq {
    
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        int N = 7;
        System.out.println(findLongestConseqSubseq2(arr, 7));
    }
    //1st Approach: using pointers
    public static int findLongestConseqSubseq(int arr[], int N)
	{
	   int cnt = 0, lastSm = Integer.MIN_VALUE, longest = 0;
	   
	   Arrays.sort(arr);
	   for(int i=0; i<N; i++)
	   {
	       if(arr[i] == lastSm + 1)
	       {
	           cnt++;
	           lastSm = arr[i];
	       }
	       else if(arr[i] != lastSm)
	       {
	           cnt = 1;
	           lastSm = arr[i];
	       }
	       longest = Math.max(cnt, longest);
	   }
	   return longest;
	}
    //2nd Approach: Using HashSet
    public static int findLongestConseqSubseq2(int arr[], int N)
	{
	   int cnt = 0, longest = 0;
	   HashSet<Integer> set = new HashSet<>();
	   for(int i=0; i<N; i++)
	        set.add(arr[i]);
	   
	   for(Integer num : set)
	   {
	       if(!set.contains(num-1))
	       {
	           while(set.contains(num))
	           {
	               cnt++;
	               num++;
	           }
	           longest = Math.max(cnt, longest);
	           cnt = 0;
	       }
	   }
	   return longest;
	}
}
