package DynamicProgramming;

public class rodCutProblem {
    public static void main(String[] args) {
        int n=5;
        int[] arr = {2, 5, 7, 8, 10};
        int i = arr.length;
        System.out.println(rodCut(i-1, n, arr));
    }
    public static int rodCut(int index, int target, int[] nums)
    {
        if(index == 0)
                return nums[index] * target;
                
        int nonPick = rodCut(index-1, target, nums);
        int pick = 0;
        if(target >= index+1)
            pick =  nums[index] + rodCut(index, target-(index+1), nums);

        return Math.max(nonPick, pick);
    }
}
