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
public class mostStonesRemoved {
    public static void main(String[] args) {
        int n=6;
        int[][] stones = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 2},
            {2, 1},
            {2, 2}
        };
        System.out.println(maxRemove(stones, n));
    }
    public static int maxRemove(int[][] stones, int n) {
        int maxRow = 0, maxCol = 0;
        for(int[] nums : stones)
        {
            int row = nums[0];
            int col = nums[1];
            maxRow = Math.max(row, maxRow);
            maxCol = Math.max(col, maxCol);
        }
        IniConfiguration2 in = new IniConfiguration2(maxRow + maxCol + 1);
        
        for(int[] nums : stones)
        {
            int row = nums[0];
            int col = nums[1] + maxRow + 1;
            in.unionBySize(row, col);
        }
        int cnt = 0;
        for(int i=0; i<in.parent.size(); i++)
            if(in.parent.get(i) == i && in.size.get(i) > 1)
                cnt++;
        return n-cnt;
    }
}
