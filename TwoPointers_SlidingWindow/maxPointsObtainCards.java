package TwoPointers_SlidingWindow;

public class maxPointsObtainCards {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(nums,k));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int cnt = 0, totalSum = 0, sum = 0, minSum = Integer.MAX_VALUE;
        int len = cardPoints.length;
        int left = 0;
        for(int right = 0; right < len; right++){
            totalSum += cardPoints[right];
            sum += cardPoints[right];
            cnt++;
            if(cnt > (len-k)){
                cnt--;
                sum -= cardPoints[left];
                left++;
            }
            if(cnt == (len-k))
                minSum = Math.min(minSum, sum);
        }
        return (len == k) ? totalSum : totalSum - minSum;
    }
}
