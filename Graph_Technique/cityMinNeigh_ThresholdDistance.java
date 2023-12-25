package Graph_Technique;

import java.util.Arrays;

public class cityMinNeigh_ThresholdDistance {
    public static void main(String[] args) {
        int n = 4, distanceThreshold = 4;
        int[][] edges = {
            {0,1,3},
            {1,2,1},
            {1,3,4},
            {2,3,1}
        }; 
        System.out.println("City = "+findTheCity(n, edges, distanceThreshold));
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
          for(int[] row : dist)
                Arrays.fill(row, (int)(1e9));
            
          for(int[] row : edges)
          {
              int u = row[0];
              int v = row[1];
              int wt = row[2];
              dist[u][v] = wt;
              dist[v][u] = wt;
          }
          
          for(int i=0; i<n; i++)
                dist[i][i] = 0;
        
          for(int k=0; k<n; k++)
          {
              for(int i=0; i<n; i++)
              {
                  for(int j=0; j<n; j++)
                  {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                  }
              }
          }
          
          int cntMax = n, city = -1;
          
          for(int i=0; i<n; i++)
          {
              int cnt = 0;
              for(int j=0; j<n; j++)
              {
                  if(dist[i][j] > 0 && dist[i][j] <= distanceThreshold)
                    cnt++;
              }
              if(cnt <= cntMax)
              {
                 cntMax = cnt;
                 city = i;
              }
          }
           return city; 
      }
}
