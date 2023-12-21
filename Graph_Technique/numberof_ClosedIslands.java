package Graph_Technique;

public class numberof_ClosedIslands {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,1,0,1,0,0,1,0},
            {1,1,0,1,1,0,1,1,1,0},
            {1,0,1,1,1,0,0,1,1,0},
            {0,1,1,0,0,0,0,1,0,1},
            {0,0,0,0,0,0,1,1,1,0},
            {0,1,0,1,0,1,0,1,1,1},
            {1,0,1,0,1,1,0,0,0,1},
            {1,1,1,1,1,1,0,0,0,0},
            {1,1,1,0,0,1,0,1,0,1},
            {1,1,1,0,1,1,0,1,1,0}
        };
        System.out.println(closedIslands(grid));
    }
    public static int closedIslands(int[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        //first row & last row
        for(int j=0; j<m; j++)
        {
            if(!vis[0][j] && board[0][j] == 0)
                dfsTraversal(0, j, board, vis);

            if(!vis[n-1][j] && board[n-1][j] == 0)
                dfsTraversal(n-1, j, board, vis);
        }
        
        //first col & last col
        for(int i=0; i<n; i++)
        {
            if(!vis[i][0] && board[i][0] == 0)
                dfsTraversal(i, 0, board, vis);
            
            if(!vis[i][m-1] && board[i][m-1] == 0)
                dfsTraversal(i, m-1, board, vis);
        }
        int  cnt = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(!vis[i][j] && board[i][j] == 0)
                {
                    cnt++;
                    dfsTraversal(i, j, board, vis);
                }
            }
        }
        return cnt;
    }
    
    public static void dfsTraversal(int i, int j, int[][] mat, boolean[][] vis)
    { 
        if(i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j]==1 || vis[i][j] == true)
            return ;
        vis[i][j] = true;
        dfsTraversal(i-1, j, mat, vis);
        dfsTraversal(i+1, j, mat, vis);
        dfsTraversal(i, j+1, mat, vis);
        dfsTraversal(i, j-1, mat, vis);

    }
}
