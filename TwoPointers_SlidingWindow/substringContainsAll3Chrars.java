package TwoPointers_SlidingWindow;

public class substringContainsAll3Chrars {
    
    public static void main(String[] args) {
        String s ="abcabc";
        System.out.println(numberOfSubstrings(s));
    }
    public static int numberOfSubstrings(String s) {
        int temp = 0, res = 0;
        int cntA = 0, cntB = 0, cntC = 0;
        int len = s.length();
        int left = 0;
        for(int right = 0; right < len; right++){
            if(s.charAt(right) == 'a')  cntA++;
            else if(s.charAt(right) == 'b') cntB++;
            else if(s.charAt(right) == 'c') cntC++;
            
            while(cntA >= 1 && cntB >= 1 && cntC >= 1){
                temp++;
                if(s.charAt(left) == 'a')   cntA--;
                else if(s.charAt(left) == 'b')  cntB--;
                else if(s.charAt(left) == 'c')  cntC--;
                left++;
            }
            res += temp;
        }
        return res;
    }
}
