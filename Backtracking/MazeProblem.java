package Backtracking;

import java.util.ArrayList;

public class MazeProblem {    
        public static void main(String[] args) {
            System.out.println(pathReturn("",3, 3));

            boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
            };
            pathObstacle("", maze, 0, 0);
            System.out.println(count(3, 7));
            // path("", 3, 3);
            // System.out.println(pathReturnDiagonal("", 3, 3));
        }
        static int count(int r, int c)
        {
            if(r == 1 || c == 1)
                return 1;
            
            int left = count(r-1, c);
            int right = count(r, c-1);

            return left + right;
        }
        static void path(String p, int r, int c)
        {
            if(r == 1 && c == 1)
            {
                System.out.println(p);
                return ;
            }
            if( r > 1)
                path(p + "D", r-1, c);

            if(c > 1)
                path(p + "R", r, c-1);
        }
        static ArrayList<String> pathReturn(String p, int r, int c)
        {
            if(r == 1 && c == 1)
            {
                ArrayList<String> al = new ArrayList<String>();
                al.add(p);
                return al;
            }
            ArrayList<String> list = new ArrayList<String>();

            if(r > 1)
            {
                 list.addAll(pathReturn(p+"D", r-1, c));
            }            

            if(c > 1)
            {
                list.addAll(pathReturn(p+"R", r, c-1));
            }
            return list;                        
        }

        static ArrayList<String> pathReturnDiagonal(String p, int r, int c)
        {
            if(r == 0 && c == 0)
            {
                ArrayList<String> al = new ArrayList<String>();
                al.add(p);
                return al;
            }
            ArrayList<String> list = new ArrayList<String>();

            if(r >= 1 && c >= 1)
            {
                list.addAll(pathReturnDiagonal(p+"V", r-1, c-1));
            }
            // if(r > 1)
            // {
            //      list.addAll(pathReturnDiagonal(p+"D", r-1, c));
            // }            

            // if(c > 1)
            // {
            //     list.addAll(pathReturnDiagonal(p+"R", r, c-1));
            // }
            return list;                        
        }

        static void pathObstacle(String p, boolean[][] maze, int r, int c)
        {
            if(r == maze.length - 1 && c == maze.length - 1)
            {
                System.out.println(p);
                return ;
            }
            
            if(maze[r][c] == false)
                return ;

            maze[r][c] = false;

            if( r < maze.length - 1)
                pathObstacle(p + "D", maze, r+1, c);

            if(c < maze.length - 1)
                pathObstacle(p + "R",maze, r, c+1);

            if(r > 0)
                pathObstacle(p + "U",maze, r-1, c);

            if(c > 0)
                pathObstacle(p + "L",maze, r, c-1);

            maze[r][c] = true;

        }
}
