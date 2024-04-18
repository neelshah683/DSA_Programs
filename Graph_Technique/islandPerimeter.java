package Graph_Technique;

public class islandPerimeter {
    static int res = 0;
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        System.out.println(res + islandPeri(grid));

    }
    public static int islandPeri(int[][] grid) {
        int res = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 0 || grid[row][col] == -1) continue;            
                res = dfsTraversal(grid, row, col);
            }
        }
        return res;
    }
    public static int dfsTraversal(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row == grid.length || col == grid[row].length || grid[row][col] == 0)
            return 1;
        
        if(grid[row][col] == -1) return 0;

        grid[row][col] = -1;

        int count = dfsTraversal(grid, row-1, col) +
               dfsTraversal(grid, row+1, col) +
               dfsTraversal(grid, row, col-1) +
               dfsTraversal(grid, row, col+1);

        return count;
    }
    public static int islandPeri2(int[][] grid){
        int prm = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 1){
                    prm  += 4;
                    if(row > 0 && grid[row-1][col] == 1)  prm -= 2;
                    if(col > 0 && grid[row][col-1] == 1)   prm -= 2;
                }
            }
        }
        return prm;
    }
}
