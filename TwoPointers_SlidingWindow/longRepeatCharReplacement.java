package TwoPointers_SlidingWindow;

public class longRepeatCharReplacement {
    
    public static void main(String[] args) {
        String str = "ABAB";
        int k = 1;
        System.out.println(characterReplacement(str, k));
    }
    public static int characterReplacement(String s, int k) {
        if(s.length() == 1) return 1;
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0, len = s.length();
        for(int right = 0; right < len;){
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(right)-'A']);
            if(right - left + 1 - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
