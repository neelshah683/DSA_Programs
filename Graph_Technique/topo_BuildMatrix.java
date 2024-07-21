package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class topo_BuildMatrix {
    
    public static void main(String[] args) {
        int[][] rowCon = {
            {1, 2},
            {3, 2}
        };
        int[][] colCon = {
            {2, 1},
            {3, 2}
        };
        int k = 3;
        System.out.println(Arrays.deepToString(buildMatrix(k, rowCon, colCon)));
    }
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int rowN = rowConditions.length;
        int colN = colConditions.length;
        ArrayList<ArrayList<Integer>> adjRow = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjCol = new ArrayList<>();

        for(int indx = 0; indx <= k; indx++)
        {
            adjRow.add(new ArrayList<>());
            adjCol.add(new ArrayList<>());
        }

        for(int[] row : rowConditions){
            int u = row[0];
            int v = row[1];
            adjRow.get(u).add(v);
        }

        for(int[] col : colConditions){
            int u = col[0];
            int v = col[1];
            adjCol.get(u).add(v);
        }

        List<Integer> rowTopo = topoSort(adjRow, k);
        List<Integer> colTopo = topoSort(adjCol, k);

        if(rowTopo.size() == 0 || colTopo.size() == 0)  return new int[][] {};

        int[][] res = new int[k][k];

        Map<Integer, Integer> strColIndx = new HashMap<>();
        for(int indx = 0; indx < colTopo.size(); indx++)
            strColIndx.put(colTopo.get(indx), indx);

        for(int indx = 0; indx < k; indx++)
            res[indx][strColIndx.get(rowTopo.get(indx))] = rowTopo.get(indx);
        
        return res;
    }
    public static List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int V){
        int[] inDeg = new int[V+1];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<=V; i++)
            for(int val : adj.get(i))
                inDeg[val]++;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i< inDeg.length; i++)
            if(inDeg[i] == 0)
                q.add(i);
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            list.add(node);

            for(int neighbour : adj.get(node))
            {
                inDeg[neighbour]--;    
                if(inDeg[neighbour] == 0)   
                    q.add(neighbour);
            }
        }

        for(int indx = 1; indx <= V; indx++)
            if(inDeg[indx] != 0)
                return new ArrayList<>();

        return list;
    }
}
