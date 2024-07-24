package Arrays;

import java.util.*;

public class sortJumbledWords {
    
    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        //OPTIMAL Approach
         int n = nums.length;
      
        int[][] mappedWithIndex = new int[n][2];
      
        for (int i = 0; i < n; ++i) {
            int originalNum = nums[i];   
            int mappedNum = originalNum == 0 ? mapping[0] : 0;  
            int placeValue = 1;   
          
            while (originalNum > 0) {
                int digit = originalNum % 10; 
                mappedNum += placeValue * mapping[digit];  
                placeValue *= 10;  
                originalNum /= 10; 
            }

            mappedWithIndex[i] = new int[] {mappedNum, i};
        }
      
        Arrays.sort(mappedWithIndex, (a, b) -> 
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); 
      
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; ++i) {
            sortedArray[i] = nums[mappedWithIndex[i][1]];
        }
      
        return sortedArray;
    }
}
