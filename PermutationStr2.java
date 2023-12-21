import java.util.ArrayList;

public class PermutationStr2{
    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbabooo";
        boolean ans = getPermute("", s1, s2);
        System.out.println(ans);
    }
    static boolean getPermute(String s, String s1, String s2)
    {
        if(s1.length()==0)
        {
           if(s2.contains(s))
                return true;
        }
        
        for(int i=0; i<=s.length(); i++)
        {
            String f = s.substring(0, i);
            String l = s.substring(i, s.length());

            if((getPermute(f + s1.charAt(0) + l, s1.substring(1), s2)) == true)
            {
                return true;
            }
        }
        return false;
    }
}