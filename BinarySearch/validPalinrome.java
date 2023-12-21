package BinarySearch;

public class validPalinrome {
    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(validPalindrome(s));
    }
    public static boolean validPalindrome(String s) {
        int len = s.length();
        for(int i=0, j=len-1; i<j; i++, j--)
        {
            if(s.charAt(i)==s.charAt(j))
                continue;
            else
            {
                if(checkPalindrome(s, i, j-1) || checkPalindrome(s, i+1, j))
                    return true;
                return false;    
            }
        }
        return true;
        
    }
    public static boolean checkPalindrome(String s, int i, int j)
        {
            if(i==j)
                return true;
            return false;    
        }
}
