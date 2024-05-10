package BinarySearch;

import java.util.Arrays;

public class kthPrimeFraction {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        double low = 0.0;
        double high = 1.0;
        while(low <= high){
            double mid = (low + high) / 2.0;
            int[] count = cntSmallEqual(arr, mid, k);
            if(count[0] == k){
                i = count[1];
                j = count[2];
                break;
            }
            else if(count[0] < k)   low = mid;
            else    high = mid;
        }
        return new int[] {i, j};
    }
    public static int[] cntSmallEqual(int[] arr, double mid, int k){
        int n = arr.length;
        int i = 0, j = 1, count = 0, resI = 0, resJ = 0;
        double maxRatio = 0.0;

        while(i < n-1){
            while(j < n && ((double)arr[i]/(double)arr[j]) > mid)
                j++;
            
            count += (n - j);
            if(j == n)  break;

            double currRatio = ((double)arr[i]/(double)arr[j]);
            if(maxRatio < currRatio){
                maxRatio = currRatio;
                resI = arr[i];
                resJ = arr[j];
            }
            i++;
        }
        return new int[] {count, resI, resJ};
    }
}
