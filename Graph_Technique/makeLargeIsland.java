package Graph_Technique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class IniConfiguration2{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    IniConfiguration2(int n)
    {
        for(int i=0; i<=n ;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    public int findUlParent(int node)
    {
        if(node == parent.get(node))
            return node;
        int val = findUlParent(parent.get(node));
        parent.set(node, val);
        return parent.get(node);    
    }
    public void unionBySize(int u, int v)
    {
        int pu = findUlParent(u);
        int pv = findUlParent(v);
        if(pu == pv)
            return ;
        if(size.get(pu) < size.get(pv))
        {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
        else
        {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}
public class makeLargeIsland {
    public static void main(String[] args) {
        int input = 3;
        int[][] grid = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1}
        };
        System.out.println(MaxConnection(grid));
    }
    public static int MaxConnection(int grid[][]) {
        int n = grid.length;
        IniConfiguration2 in = new IniConfiguration2(n * n);
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                    continue;
                for(int[] dr : dir)
                {
                    int row = i + dr[0];
                    int col = j + dr[1];
                    if(row >= 0 && row<n && col>=0 && col<n && grid[row][col] == 1)
                    {
                        int adjNode = (row * n) + col;
                        int node = (i * n) + j;
                        in.unionBySize(node, adjNode);
                    }
                }
            }
        }
        int maxCnt = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                    continue;
                    
                HashSet<Integer> set = new HashSet<>();

                for(int[] dr: dir)
                {
                    int row = i + dr[0];
                    int col = j + dr[1];
                    if(row>=0 && row<n && col >=0 && col<n && grid[row][col] == 1)
                    {
                        int adjNode = (row * n) + col;
                        set.add(in.findUlParent(adjNode));
                    }
                }
                int cnt = 0;
                for(Integer val : set)
                    cnt += in.size.get(val);
                maxCnt = Math.max(cnt + 1, maxCnt);
            }
        }
        return (maxCnt == 0) ? n*n : maxCnt;
    }
}
