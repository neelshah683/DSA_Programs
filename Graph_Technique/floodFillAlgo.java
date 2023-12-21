package Graph_Technique;

import java.util.Arrays;

public class floodFillAlgo {
    public static void main(String[] args) {
        int[][] a = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        floodFill(a, 2, 0, 2);
        for(int[] row : a)
        {
            System.out.println(Arrays.toString(row));
        }
        // System.out.println(Arrays.deepToString(floodFill(a, 2, 0, 3)));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        dfsTraversal(image, sr, sc, iniColor, newColor);
        return image;
    }
    public static void dfsTraversal(int[][] grid, int row, int col, int iniColor, int newColor)
    {
        if( row < 0 || row == grid.length || col < 0 || col == grid[row].length || grid[row][col] != iniColor || iniColor == newColor)
            return ;
        grid[row][col] = newColor;
        dfsTraversal(grid, row-1, col, iniColor, newColor);
        dfsTraversal(grid, row+1, col, iniColor, newColor);
        dfsTraversal(grid, row, col-1, iniColor, newColor);
        dfsTraversal(grid, row, col+1, iniColor, newColor);

    }
}
