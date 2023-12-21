import java.util.Arrays;

public class longestRepeatSubstring {
    
    public static void main(String[] args) {
        String s = "54994";
        System.out.println(longestSemiRepetitiveSubstring(s));
    }
    public static int longestSemiRepetitiveSubstring(String s) {
        
        char[] ch = s.toCharArray();
        
        for(int i=0; i<ch.length-1; i++)
        {
            if(ch[i] == ch[i+1])
            {
                return ch.length - (i+1)+1;
            }
        }
        return ch.length;
    }
}
