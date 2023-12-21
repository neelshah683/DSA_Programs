public class MergeString {
    
    public static void main(String[] args) {
        
        String word1 = "ab";
        String word2 = "pqrs";
        String res = mergeStr(word1, word2);
        System.out.println(res);
    }
    static String mergeStr(String s1, String s2)
    {
        String ans = "";
        int i, j;
        for(i=0, j=0; i<s1.length() && j < s2.length(); i++, j++)
        {
            ans = ans + String.valueOf(s1.charAt(i)) + String.valueOf(s2.charAt(j));

        }
        if(i == s1.length())
            return ans+s2.substring(j);
        else    
            return ans+s1.substring(i);
    }

}
