package BinarySearch;

public class search2DMatrix_2 {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };
        System.out.println(searchMatrix(matrix, 15));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = m-1, col = 0;
        while(row >= 0 && col < n)
        {
            if(target == matrix[row][col])
                return true;
            else if(target > matrix[row][col])
                col++;
            else
                row--;
        }
        return false;
    }
}
