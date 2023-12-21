package Graph_Technique;

import java.util.Arrays;

public class surroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        solve(board);
        for(char[] row : board)
        {
            System.out.println(Arrays.toString(row));
        }
        // System.out.println(Arrays.deepToString(solve(board)));
    }
    public static char[][] solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        //first row & last row
        for(int j=0; j<m; j++)
        {
            if(!vis[0][j] && board[0][j] == 'O')
                dfsTraversal(0, j, board, vis);

            if(!vis[n-1][j] && board[n-1][j] == 'O')
                dfsTraversal(n-1, j, board, vis);
        }
        
        //first col & last col
        for(int i=0; i<n; i++)
        {
            if(!vis[i][0] && board[i][0] == 'O')
                dfsTraversal(i, 0, board, vis);
            
            if(!vis[i][m-1] && board[i][m-1] == 'O')
                dfsTraversal(i, m-1, board, vis);
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return board;
    }
    public static void dfsTraversal(int i, int j, char[][] mat, boolean[][] vis)
    {
        if(i < 0 || i == mat.length || j < 0 || j == mat[i].length || mat[i][j]=='X' || vis[i][j] == true)
            return ;
        vis[i][j] = true;
        dfsTraversal(i-1, j, mat, vis);
        dfsTraversal(i+1, j, mat, vis);
        dfsTraversal(i, j+1, mat, vis);
        dfsTraversal(i, j-1, mat, vis);

    }
}
