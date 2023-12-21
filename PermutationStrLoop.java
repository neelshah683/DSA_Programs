public class PermutationStrLoop {
    
    public static void main(String[] args) {
        
        String s1 = "ab";
        String s2 = "eidbabooo";
        // boolean ans = 
        getPermute("", s1, s2);
        // System.out.println(ans);
    }
    static void getPermute(String s, String s1, String s2)
    {
        for(int i=0; i<=s1.length(); i++)
        {
            for(int j=0; j<s.length()+1;j++)
            {
                String f = s.substring(0, j);
                String l = s.substring(j, s.length());

                String ans = f + s1.charAt(0) + l;
                System.out.println(ans);
            }
        }
    }
}
