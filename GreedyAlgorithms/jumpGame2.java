package GreedyAlgorithms;

public class jumpGame2 {
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 3, 1, 1, 2};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int coverage = 0, lastJumpIndx = 0;
        int dest = nums.length-1;
        int totalJump = 0;
        for(int indx = 0; indx < nums.length-1; indx++){
            coverage = Math.max(coverage, indx + nums[indx]);
            if(indx == lastJumpIndx){
                lastJumpIndx = coverage;
                totalJump++;
                if(coverage >= dest) return totalJump;
            }
        }
        return totalJump;
    }
}
