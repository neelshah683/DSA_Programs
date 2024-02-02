package BinarySearch;

/**
 * search2DMatrix_1
 */
public class search2DMatrix_1 {

    public static void main(String[] args) {
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        System.out.println(searchMatrix(matrix, 20));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = n * m - 1;
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}