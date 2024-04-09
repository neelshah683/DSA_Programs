package GreedyAlgorithms;

import java.util.*;

class Job {
    int id, deadline, profit;
    Job(int id, int dl, int pf){
        this.id = id;
        this.deadline = dl;
        this.profit = pf;
    }
}
public class jobScheduling {
    
    public static void main(String[] args) {
        int n = 4;
        Job arr[] = new Job[n];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 1, 40);
        arr[3] = new Job(4, 1, 30);

        System.out.println(Arrays.toString(JobScheduling(arr, n)));
    }
    public static int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));
        
        int maxi = -1;
        for(int indx = 0; indx < arr.length; indx++){
           if(arr[indx].deadline > maxi)
                maxi = arr[indx].deadline;
        }
        int[] result = new int[maxi + 1];
        Arrays.fill(result, -1);
        
        int maxProfit = 0, cntJobDone = 0;
        for(int indx = 0; indx < arr.length; indx++){
            int jobId = arr[indx].id;
            int jobDl = arr[indx].deadline;
            int pf = arr[indx].profit;
            
            for(int indx2 = jobDl; indx2 >= 1; indx2--){
                if(result[indx2] == -1){
                    result[indx2] = jobId;
                    cntJobDone++;
                    maxProfit += pf;
                    break;
                }
            }
        }
        
        return new int[] {cntJobDone, maxProfit};
    }
}
