package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;

class PairSMD{
    int timePass, node;
    PairSMD(int t, int num){
        this.timePass = t;
        this.node = num;
    }
}
public class secondMintime_to_dest_dijkstra {
    
    public static void main(String[] args) {
        int n = 5, time = 3, change = 5;
        int[][] edges = {
            {1,2},
            {1,3},
            {1,4},
            {3,4},
            {4,5}
        };
        System.out.println(secondMinimum(n,edges,time, change));

    }
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int indx = 0; indx <= n; indx++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] min1 = new int[n+1];
        Arrays.fill(min1, (int)1e9);
        min1[1] = 0;

        int[] min2 = new int[n+1];
        Arrays.fill(min2, (int)1e9);

        PriorityQueue<PairSMD> pq = new PriorityQueue<PairSMD>((x,y) -> (x.timePass - y.timePass));
        pq.add(new PairSMD(0, 1));

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int timePass = pq.peek().timePass;
            pq.poll();

            if(node == n && min2[node] != (int)1e9)
                return min2[node];

            int chk = (timePass / change) % 2;
            int currTime = (chk == 1) ? (timePass / change + 1) * change : timePass;

            for(int neighbour : adj.get(node)){

                int check = currTime + time;

                if(min1[neighbour] > check){
                    min2[neighbour] = min1[neighbour];
                    min1[neighbour] = check;
                    pq.add(new PairSMD(check, neighbour));
                }
                else if(min2[neighbour] > check && min1[neighbour] != check){
                    min2[neighbour] = check;
                    pq.add(new PairSMD(check, neighbour));
                }
            }
        }
        return 0;
    }   
}
