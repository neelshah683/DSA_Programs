package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * spiralMatrix
 */
public class spiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bottom = n-1, left = 0, right = m-1;
        List<Integer> list = new ArrayList<>();

        while(top <= bottom && left <= right)
        {
            for(int i=left; i<=right; i++)
                list.add(matrix[top][i]);
            top++;

            for(int i=top; i<=bottom; i++)
                list.add(matrix[i][right]);
            right--;

            //this edge  case to check if there is single row
            if(top <= bottom) {
                for(int i=right; i>=left; i--)
                    list.add(matrix[bottom][i]);
                bottom--;
            }
            //this edge case to check if there is single column
            if(left <= right) {
                for(int i=bottom; i>=top; i--)
                    list.add(matrix[i][left]);
                left++;
            }
        }
        return list;
    }
}