package Graph_Technique;

import java.util.ArrayList;
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
public class numberOfIslands_2 {
    public static void main(String[] args) {
        int n = 4, m = 5, k = 4;
        int[][] A = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(numOfIslands(n, m, A));
    }
    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> ans = new ArrayList<>();
        IniConfiguration2 in = new IniConfiguration2(rows * cols);
        int[][] vis = new int[rows][cols];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int cnt = 0;
        for(int[] arr : operators)
        {
            int row = arr[0];
            int col = arr[1];
            if(vis[row][col] != 1)
            { 
                vis[row][col] = 1;
                cnt++;
                
                for(int[] dr : dir)
                {
                int rl = row + dr[0];
                int cl = col + dr[1];
                    if(rl >= 0 && rl < rows && cl >=0 && cl < cols)
                    {
                        if(vis[rl][cl] == 1)
                        {
                            int adjNode = (rl * cols) + cl;
                            int node = (row * cols) + col;
                            if(in.findUlParent(node) != in.findUlParent(adjNode))
                            {
                                in.unionBySize(node, adjNode);
                                cnt--;
                            }
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
