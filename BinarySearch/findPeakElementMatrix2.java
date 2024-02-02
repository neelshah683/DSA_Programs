package BinarySearch;

import java.util.Arrays;

public class findPeakElementMatrix2 {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };
        System.out.println(Arrays.toString(findPeakGrid1(matrix)));
    }
    //TC: O(N * Log M) SC: O(1)
    public static int[] findPeakGrid1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = n - 1;
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            int row = maxElCol(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < n ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right)
                return new int[] {row, mid};
            else if(left > mat[row][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return new int[] {-1, -1};
    }
    public static int maxElCol(int[][] arr, int n, int m, int col)
    {
        int maxi = Integer.MIN_VALUE, index = -1;
        for(int i=0; i<m; i++)
        {
            if(arr[i][col] > maxi)
            {
                maxi = arr[i][col];
                index = i;
            }
        }
        return index;
    }
    //TC: O(M+4*N) SC: O(dir[][])
    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int row = 0, col = 0;

        int[][] dir = {{-1, 0}, {0, 1}, {1,0}, {0, -1}};
        while(row < m && col < n)
        {
            int chkRow = row;
            int chkCol = col;
            for(int[] d : dir)
            {
                int newRow = chkRow + d[0];
                int newCol = chkCol + d[1];
                if(newRow >=0 && newRow < m && newCol >=0 && newCol < n)
                {
                    if(mat[chkRow][chkCol] < mat[newRow][newCol])
                    {
                        chkRow = newRow;
                        chkCol = newCol;
                        break;
                    }
                }
            }
            if(chkRow == row && chkCol == col)
                return new int[] {row, col};
            else
                {
                    row = chkRow;
                    col = chkCol;
                }
        }
        return new int[] {-1, -1};
    }
}
