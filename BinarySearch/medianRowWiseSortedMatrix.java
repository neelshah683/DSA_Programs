package BinarySearch;

public class medianRowWiseSortedMatrix {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        System.out.println(median(matrix, 3, 3));
    }

    public static int countSmallEqual(int[][] mat, int ele, int row, int col)
    {
        int cnt = 0;
        for(int i=0; i<row; i++)
            cnt += upperBound(mat[i], ele);
        return cnt; 
    }
    public static int upperBound(int[] arr, int ele)
    {
        int low = 0, high = arr.length-1;
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(arr[mid] > ele)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high + 1;
    }
    public static int median(int matrix[][], int R, int C) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        
        for(int i=0; i<R; i++)
        {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C-1]);
        }
        int req = (R * C) / 2;
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            int smallEqual = countSmallEqual(matrix, mid, R, C);
            if(smallEqual <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
