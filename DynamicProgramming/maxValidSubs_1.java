package DynamicProgramming;

public class maxValidSubs_1 {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maximumLength(nums));
    }
    public static int maximumLength(int[] nums) {
        int n = nums.length;
        int[] same = new int[2];
        int[] diff = new int[2];

        for(int indx = 0; indx < n; indx++){
            int curr = nums[indx] % 2;
            same[curr] = same[curr] + 1;
            diff[curr] = Math.max(diff[curr], 1 + diff[1 ^ curr]);
        }
        return Math.max(diff[0], Math.max(diff[1], Math.max(same[0], same[1])));
    }
}
