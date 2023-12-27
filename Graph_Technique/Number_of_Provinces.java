package Graph_Technique;

import java.util.ArrayList;

public class Number_of_Provinces {
    
    public static void main(String[] args) {
        int[][] a = {
            {0, 0, 1},
            {0, 0, 1},
            {1, 1, 0}
        };
        System.out.println("Number of provinces: " + findCircleNum2(a));
    }
    //1ST APPROACH
    //USING ADJACENCY LIST
    //CONVERT ADJACENT MATRIX TO LIST
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<v; i++)
            adjLs.add(new ArrayList<Integer>());

        for(int i=0; i<v; i++)
        {
            for(int j=0; j<v; j++)
            {
                if(isConnected[i][j] == 1)
                    adjLs.get(i).add(j);
            }
        }
        int cnt = 0;
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++)
        {
            if(!vis[i])
            {
                cnt++;
                dfsTraversal(i, vis, adjLs);
            }
        }
        return cnt;
    }
    public void dfsTraversal(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = true;
        
        for(int neighbour : adj.get(node))
        {
            if(!vis[neighbour])
                dfsTraversal(neighbour,vis, adj);
        }
    }

    //2ND Approach: Without Adjacency List
    static int v;
    public static int findCircleNum2(int[][] isConnected) {
        v = isConnected.length;
        int cnt = 0;
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++)
        {
            if(!vis[i])
            {
                cnt++;
                dfsTraversal2(i, vis, isConnected);
            }
        }
        return cnt;
    }
    public static void dfsTraversal2(int i, boolean[] vis, int[][] a)
    {        
        for(int j=0; j<v; j++)
        {
            if(a[i][j] == 1 && !vis[j])
            {
                vis[j] = true;
                dfsTraversal2(j, vis, a);
            }
        }
    }
}
//Using Disjoint Set - Union Find
/*
 class IniConfiguration2 {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public IniConfiguration2(int n)
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

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        IniConfiguration2 inConfig = new IniConfiguration2(n);
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    inConfig.unionBySize(i,j);
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++)
        {
            if(inConfig.parent.get(i) == i)
                ++cnt;
        }
        return cnt;
    }
}
 */
