package TwoPointers_SlidingWindow;

public class getEqualSubstr_withinBudget {
    
    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s, t, maxCost));
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0, maxLength = 0;
        int currCost = 0;
        int n = s.length();

        for(int right = 0; right < n; right++){
            currCost += Math.abs(s.charAt(right)-t.charAt(right));
            while(currCost > maxCost && left <= right){
                currCost -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
