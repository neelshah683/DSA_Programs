package Arrays;

import java.util.Arrays;

public class Three_3Sum_smallerX {
    
    public static void main(String[] args) {
        long[] nums = {5, 1, 3, 4, 7};
        int N = 5, sum = 12;
        System.out.println(countTriplets(nums, N, sum));
    }
    public static long countTriplets(long arr[], int n,int sum)
    {
        long cnt = 0;
        Arrays.sort(arr);
       for(int i=0; i<n; i++)
       {
           if(i > 0 && arr[i] == arr[i-1])
                continue;

            int j=i+1;
            int k = n-1;
            while(j < k)
            {
              long res = arr[i] + arr[j] + arr[k];
              if(res < sum)
              {
                  cnt += (k - j);
                  j++;
              }
              else
                    k--;
            }
            
       }
       return cnt;
    }
}
