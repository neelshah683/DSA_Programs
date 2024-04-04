package GreedyAlgorithms;

import java.util.Arrays;

public class maxUnitsTruck {
    
    public static void main(String[] args) {
        int[][] boxTypes = {
            {1, 3},
            {2, 2},
            {3, 1}
        };
        System.out.println(maximumUnits(boxTypes, 4));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> (b[1] - a[1]));
        int len = boxTypes.length;
        int currBoxNo = 0;
        int res = 0;
        for(int indx = 0; indx < len; indx++){
            if(currBoxNo + boxTypes[indx][0] <= truckSize){

                int curBox = boxTypes[indx][0];
                int units = boxTypes[indx][1];

                currBoxNo += curBox;
                res += (curBox * units);
            }
            else{
                int remain = truckSize - currBoxNo;
                res += (remain * boxTypes[indx][1]);
                break;
            }
        }
        return res;
    }
}
