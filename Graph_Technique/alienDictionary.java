package Graph_Technique;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class alienDictionary {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        int N = 5, K = 4;
        System.out.println("Alien Dictionary: " + findOrder(dict, N, K));
    }
    public static String topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDeg = new int[V];
        String s = "";
        
        int x = 0;
        for(int i=0; i<V; i++)
            for(int val : adj.get(i))
                inDeg[val]++;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDeg.length; i++)
            if(inDeg[i] == 0)
                q.add(i);
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            s = s + (char)(node + (int)'a');

            for(int neighbour : adj.get(node))
            {
                inDeg[neighbour]--;    
                if(inDeg[neighbour] == 0)   
                    q.add(neighbour);
            }
        }
        return s;
    }
    public static String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0; i<N-1; i++)
        {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++)
            {
                if(s1.charAt(j) != s2.charAt(j))
                {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break; 
                }
            }
        }
        return topoSort(K, adj);
    }
}
