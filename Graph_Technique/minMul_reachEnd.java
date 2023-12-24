package Graph_Technique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class minMul{
    int first, second;
    minMul(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class minMul_reachEnd {
    
    public static void main(String[] args) {
        int arr[] = {2, 5, 7};
        int start = 3, end = 30;
        System.out.println(minimumMultiplications(arr, start, end));
    }
    public static int minimumMultiplications(int[] arr, int start, int end) {

        Queue <minMul> q = new LinkedList<>();
        q.add(new minMul(0, start));
        
        int mod = 100000;
        int[] dist = new int[mod];
        Arrays.fill(dist, (int)(1e9));
        dist[start] = 0;
        
        while(!q.isEmpty())
        {
            int steps = q.peek().first;
            int node = q.peek().second;
            q.remove();
            
            if(node == end)
                return steps;
            for(int num : arr)
            {
                int val = (node * num) % mod;
                if(steps + 1 < dist[val])
                {
                    dist[val] = steps + 1;
                    q.add(new minMul(dist[val], val));
                }
            }
        }
        return -1;
    }
}
