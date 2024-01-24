package Arrays;

import java.util.Arrays;

public class findMissing_Repeatitive {
    
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        int n = 6;
        System.out.println(Arrays.toString(findTwoElement1(arr, n)));
    }
    //BitManipulation Solution
    public static int[] findTwoElement1(int arr[], int n) {
        
        int xor = 0;
        for(int i=0; i<n; i++)
        {
            xor ^= arr[i];
            xor ^= (i+1);
        }
        
        int num = (xor & ~(xor-1));
        
        int zero = 0, one = 0;
        for(int i=0; i<n; i++)
        {
           if((arr[i] & num) != 0)
                one ^= arr[i];
            else
                zero ^= arr[i];
        }
        for(int i=1; i<=n; i++)
        {
           if((i & num) != 0)
                one ^= i;
            else
                zero ^= i;
        }
        int cnt = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[i] == zero)
                cnt++;
        }
        return (cnt == 2) ? new int[]{zero, one} : new int[]{one, zero};
    }
    //Maths Solution
    public static int[] findTwoElement(int arr[], int n) {
        
        long y1 = (n * (n+1))/2;
        long y2 = (n * (n+1) * (2*n+1))/6;
        
        long x1 = 0, x2 = 0;
        for(int i=0; i<n; i++)
        {
            x1 += arr[i];
            x2 += (long)arr[i] * (long)arr[i];
        }
        
        long x = x1-y1;
        long y = x2-y2; 
        y = y / x;
        
        long res1 = (y+x)/2;
        long res2 = y - res1;
        
        return new int[] {(int)res1, (int)res2};
    }
}
