package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {
            {1,3},
            {0,2},
            {1,3},
            {0,2}
        };
        System.out.println(chkBpt(graph));
    }
    public static boolean chkBpt(int[][] graph)
    {
        int V = graph.length;
        int[] vis = new int[V];
        Arrays.fill(vis, -1);

        for(int i=0; i<V;i++)
        {
            if(vis[i] == -1)
            {
                vis[i] = 0;
                if(!chkBpt3(graph, i, vis))
                    return false;
            }
                
        }  
        return true;
    }

    //Using BFS Traversal
    public static boolean chkBpt2(int[][] graph, int start, int[] vis)
    {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis[start] = 0;

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int neighbour : graph[node])
            {
                if(vis[neighbour]==-1)
                {
                    q.add(neighbour);
                    vis[neighbour]= (vis[node]+1)%2; //coloring the nodes with alternate color
                }
                else if(vis[neighbour] == vis[node])
                {
                    return false;
                }
            }
        }
        return true;
    }

    //Using DFS Traversal
    public static boolean chkBpt3(int[][] graph, int start, int[] vis)
    {
        for(int neighbour : graph[start])
        {
            if(vis[neighbour]==-1)
            {
               vis[neighbour]= (vis[start]+1)%2; //coloring the nodes with alternate color
                if(!chkBpt3(graph, neighbour, vis))
                    return false;
            }
            else if(vis[neighbour] == vis[start])
                return false;
        }
        return true;
    }

}
