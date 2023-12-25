package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algo {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 0, 1)));

        int S = 2, V = 3;
        System.out.println(Arrays.toString(bellman_ford(V, edges, S)));
    }
    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e8));
        dist[S] = 0;
        
        for(int i=0; i<V-1; i++)
        {
            for(ArrayList<Integer> edge : edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(ArrayList<Integer> edge : edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v])
                {
                    int[] temp = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
            return dist;
    }
}
