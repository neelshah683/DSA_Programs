package DynamicProgramming.Rectangle_Square;

public class maximalSqaure {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int[][] nums = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix[0].length; i++)
        {
            nums[0][i] = matrix[0][i]-'0';
        }

        for(int j=0; j<matrix.length; j++)
        {
            nums[0][j] = matrix[0][j]-'0';
        }

        int maxi = 0;
        for(int i=1; i<matrix.length; i++)
        {
            for(int j=1; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == '0')
                    nums[i][j] = 0;
                else    
                    nums[i][j] = 1 + Math.min(nums[i][j-1] ,Math.min(nums[i-1][j], nums[i-1][j-1]));
                maxi = Math.max(maxi, nums[i][j]);
            }
        }
        System.out.println(maxi*maxi);
    }
}
