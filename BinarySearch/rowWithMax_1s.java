package BinarySearch;

import java.util.Arrays;

public class rowWithMax_1s {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0},
            {0, 1, 1}
        };
        System.out.println(Arrays.toString(rowAndMaximumOnes(matrix)));
    }
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length, m = mat[0].length, maxi=0, rowIndex = 0;
        int[] res = new int[2];
        for(int index = 0; index < mat.length; index++)
        {
            int cnt = countOnes(mat[index], m);
            if(cnt > maxi)
            {
                maxi = cnt;
                rowIndex = index;
            }   
        }
        return new int[] {rowIndex, maxi};
    }
    public static int countOnes(int[] arr, int n)
    {
        int low = 0, high = n-1;
        Arrays.sort(arr);
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(arr[mid] == 1)
                high = mid -1;
            else
                low = mid + 1;
        }
        return n-low;
    }
}
