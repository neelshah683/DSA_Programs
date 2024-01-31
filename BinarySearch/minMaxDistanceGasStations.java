package BinarySearch;

public class minMaxDistanceGasStations {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int K = 9;
        System.out.println(findSmallestMaxDist(nums, K));
    }
    //OPTIMAL APPROACH TC: O(NLogK) + O(N) SC: O(1)
    public static double findSmallestMaxDist1(int stations[],int K) {
        double low = 0, high = (double)maxDistance(stations);
        while(high-low > (1e-9))
        {
            double mid = (low + high) / 2.0;
            if(chkPossible(stations, mid, K)==true)
                high = mid;
            else
                low = mid;
        }
        return high;
      }
      public static int maxDistance(int[] nums)
      {
          int n = nums.length, maxi = Integer.MIN_VALUE;
          for(int index = 0; index < n-1; index++)
            maxi = Math.max(maxi, nums[index+1]-nums[index]);
        
        return maxi;
      }
      public static boolean chkPossible(int[] nums, double dist, int k)
      {
          int cntPlace = 0, n = nums.length;
          
          for(int index = 1; index < n; index++)
          {
              int diff = (int)((nums[index]-nums[index-1]) / dist);
              if((diff * dist) == (nums[index]-nums[index-1]))
                    diff--;
              cntPlace += diff;   
          }
          return (cntPlace <= k) ? true : false;
      }

    //BRUTE FORCE APPROACH : TC:O(K*N) + O(N)
    public static double findSmallestMaxDist(int stations[],int K) {
        int n = stations.length;
        int[] howManyPlace = new int[n-1];
        for(int index=1; index<=K; index++)
        {
            double maxVal = -1;
            int maxIndex = -1;
            for(int index2=0; index2 < n-1; index2++)
            {
                double diff = (stations[index2+1]-stations[index2]);
                double secLen = diff / (double)(howManyPlace[index2]+1);
                
                if(maxVal < secLen)
                {
                    maxVal = secLen;
                    maxIndex = index2;
                }
            }
            howManyPlace[maxIndex]++;
        }
        double maxAns = -1;
        for(int index3 = 0; index3 < n-1; index3++)
        {
            double diff = (stations[index3+1]-stations[index3]);
            double secLen = diff / (howManyPlace[index3]+1);
            
            maxAns = Math.max(maxAns, secLen);
        }
        return maxAns;
  }
}
