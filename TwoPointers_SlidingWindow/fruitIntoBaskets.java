package TwoPointers_SlidingWindow;

public class fruitIntoBaskets {
    
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(nums));
    }
    public static int totalFruit(int[] fruits) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = -1, ele2 = -1;
        int maxLen = -1, len = fruits.length;
        int left = 0;
        for(int right = 0; right < len; right++){
            if(cnt1 == 0 && fruits[right] != ele2){
                cnt1++;
                ele1 = fruits[right];
            }
            else if(cnt2 == 0 && fruits[right] != ele1){
                cnt2++;
                ele2 = fruits[right];
            }
            else if(fruits[right] == ele1)
                cnt1++;
            else if(fruits[right] == ele2)
                cnt2++;
            else if(fruits[right] != ele1 && fruits[right] != ele2){
                while((cnt1 > 0 && cnt2 > 0) && left <= right){
                    if(fruits[left] == ele1)
                        cnt1--;
                    else
                        cnt2--;
                    left++;
                }
                if(cnt1 == 0 && fruits[right] != ele2){
                    cnt1++;
                    ele1 = fruits[right];
                }
                else if(cnt2 == 0 && fruits[right] != ele1){
                    cnt2++;
                    ele2 = fruits[right];
                }
            }
            maxLen = Math.max(maxLen, cnt1 + cnt2);
        }
        return maxLen;
    }
}
