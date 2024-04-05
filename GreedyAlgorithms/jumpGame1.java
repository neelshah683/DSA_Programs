package GreedyAlgorithms;

public class jumpGame1 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int finalPos = nums.length - 1;
        for(int indx = finalPos-1; indx >= 0; indx--){
            if(indx + nums[indx] >= finalPos)
                finalPos = indx;
        }
        return finalPos == 0;
    }
}
