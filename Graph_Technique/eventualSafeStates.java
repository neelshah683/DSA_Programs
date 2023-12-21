package Graph_Technique;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class eventualSafeStates {
    
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        System.out.println('b' - 'a');

        System.out.println(eventualSafeNodes(graph));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<V; i++)
        {
            if(!vis[i])
                dfsTraversal(i, vis, pathVis, list, graph);
        }
        Collections.sort(list);
        return list;
    }
    public static boolean dfsTraversal(int node, boolean[] vis, boolean[] pathVis, ArrayList<Integer> list, int[][] graph)
    {
        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour : graph[node])
        {
            if(!vis[neighbour])
            {
                if(dfsTraversal(neighbour, vis, pathVis, list, graph)==true)
                    return true;
            }
            else if(pathVis[neighbour] == true)
                return true;
        }
        pathVis[node] = false;
        list.add(node);
        return false;
    }
}
