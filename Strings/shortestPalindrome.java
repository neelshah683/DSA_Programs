package Strings;

public class shortestPalindrome {
    
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
    public static String shortestPalindrome(String s) {
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int[] lpsArr = new int[str.length()];
        computeKMP(str, lpsArr);
        return new StringBuilder(s.substring(lpsArr[str.length()-1])).reverse().toString() + s;
    }
    public static void computeKMP(String s, int[] lpsArr){
        int len = s.length();

        for(int indx = 1; indx < len; indx++){
            int prevIndx = lpsArr[indx - 1];

            while(prevIndx > 0 && s.charAt(indx) != s.charAt(prevIndx))
                prevIndx = lpsArr[prevIndx - 1];
            
            lpsArr[indx] = prevIndx + (s.charAt(indx) == s.charAt(prevIndx) ? 1 : 0);
        }
    }
}
