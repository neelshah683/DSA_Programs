package Arrays;

import java.util.Arrays;

public class setMatrixZeros {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    //1st Approach: Better using row & col array
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(matrix[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
    //2nd Approach: Using Optimal Approach
    public static void setZeroes2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, col0 = 1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if((matrix[i][j] == 0))
                {
                    matrix[i][0] = 0;

                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;    
                }
            }
        }

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(matrix[i][j] != 0)
                {
                    if(matrix[0][j] == 0 || matrix[i][0] == 0)
                        matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0)
        {
            for(int j=1; j<m; j++)
                matrix[0][j] = 0;
        }
        if(col0 == 0)
        {
            for(int i=0; i<n; i++)
                matrix[i][0] = 0;
        }
    }
}
