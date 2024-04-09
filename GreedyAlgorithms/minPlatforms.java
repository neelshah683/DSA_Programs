package GreedyAlgorithms;

import java.util.*;
public class minPlatforms {
    
    public static void main(String[] args) {
        int[] start = {120, 50, 550, 200, 700, 850};
        int[] end = {600, 550, 700, 500, 900, 1000};
        int n = 6;
        System.out.println("Minimum Platform Required: "+findPlatform(start, end, n));
    }
    public static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int ptf = 1, res = 1;
        int indx1 = 1, indx2 = 0;
        
        while(indx1 < n && indx2 < n){
            
            if(arr[indx1] <= dep[indx2]){
                ptf++;
                indx1++;
            }
            else if(arr[indx1] > dep[indx2]){
                ptf--;
                indx2++;
            }
            
            if(ptf > res)   res = ptf;
        }
        return res;
    }
}
