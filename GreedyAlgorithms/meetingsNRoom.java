package GreedyAlgorithms;

import java.util.Arrays;

public class meetingsNRoom{
    
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = 6;
        System.out.println(maxMeetings(start, end, n));
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meetings = new int[n][2];
        for(int indx = 0; indx < n; indx++){
            meetings[indx][0] = start[indx];
            meetings[indx][1] = end[indx];
        }
        //sort data using start time but in descending order:
        Arrays.sort(meetings, (a,b) -> (b[0] - a[0]));
    
        
        int startM = meetings[0][0], endM = meetings[0][1];
        int cntMeet = 1;
        for(int indx = 1; indx < n; indx++){
            if(meetings[indx][1] < startM){
                cntMeet++;
                startM = meetings[indx][0];
                endM = meetings[indx][1];
            }
        }
        return cntMeet;
    }
}
