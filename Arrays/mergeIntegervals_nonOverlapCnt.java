package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class mergeIntegervals_nonOverlapCnt {
    
    public static void main(String[] args) {
        int[][] nums ={
            {-52,31},
            {-73,-26},
            {82,97},
            {-65,-11},
            {-62,-49},
            {95,99},
            {58,95},
            {-31,49},
            {66,98},
            {-63,2},
            {30,47},
            {-40,-26}
        };


        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        }); 

        System.out.println(Arrays.deepToString(nums));
    }
}
