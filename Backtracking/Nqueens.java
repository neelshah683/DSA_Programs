package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char [n][n];
        helper(board, allBoards, 0);

        return allBoards;

    }
    public static boolean isSafe(int row, int col, char[][] board)
    {
        //horizontal
        for(int j=0; j<board.length; j++)
        {
            if(board[row][j] == 'Q')
                return false;
        }
 

        //upperLeft
        for(int r = row, c = col; r>=0 && c>=0; r--, c--)
        {
            if(board[r][c] == 'Q')
                return false;
        }

        //upperRight
        for(int r = row, c = col; r>=0 && c<=board.length-1; r--, c++)
        {
            if(board[r][c] == 'Q')
                return false;
        }
        
        //lowerLeft
        for(int r = row, c = col; r<=board.length-1 && c>=0; r++, c--)
        {
            if(board[r][c] == 'Q')
                return false;
        }
        
        //lowerRight
        for(int r = row, c = col; r<=board.length-1 && c<=board.length-1; r++, c++)
        {
            if(board[r][c] == 'Q')
                return false;
        }
        return true;
    }
    public static void saveBoard(char[][] board, List<List<String>> allBoards)
    {
            String row = "";
            List<String> newBoard = new ArrayList<>();

            for(int i = 0; i<board.length; i++)
            {
                row = "";
                for(int j=0; j<board[i].length; j++)
                {
                    if(board[i][j] == 'Q')
                        row+='Q';
                    else
                        row+='.';
                }
                newBoard.add(row);
            }
            allBoards.add(newBoard);
    }

    public static void helper(char[][] board, List<List<String>> allBoards, int col)
    {
       if(col == board.length)
       {
            saveBoard(board, allBoards);
            return ;
       }
        for(int row = 0; row < board.length; row++)
        {
            if(isSafe(row, col, board))
            {
                board[row][col] = 'Q';
                helper(board, allBoards, col+1);
                board[row][col] = '.';
 
            }
        }
    }
}
