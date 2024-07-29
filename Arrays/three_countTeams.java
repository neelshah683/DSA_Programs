package Arrays;

public class three_countTeams {
    
    public static void main(String[] args) {
        int[] nums = {2,5,3,4,1};
        System.out.println(numTeams(nums));
    }
    public static int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            int leftMin = 0;
            int leftMax = 0;
            int rightMin = 0;
            int rightMax = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftMin++;
                } else if (rating[j] > rating[i]) {
                    leftMax++;
                }
            }

            for (int k = i + 1; k < n; k++) {
                if (rating[k] < rating[i]) {
                    rightMin++;
                } else if (rating[k] > rating[i]) {
                    rightMax++;
                }
            }

            count += leftMin * rightMax + leftMax * rightMin;
        }

        return count;
    }
}
