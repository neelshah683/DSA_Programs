public class MergeStringRecursion {
    
    public static void main(String[] args) {
        
        String word1 = "abc";
        String word2 = "pqrs";
        String res = mergeStr(word1, word2);
        System.out.println(res);
    }
    static String mergeStr(String s1, String s2)
    {
        if(s1.isEmpty())
            return s2.substring(0);
        else if(s2.isEmpty())
            return s1.substring(0);

        return ""+s1.charAt(0) + s2.charAt(0) + mergeStr(s1.substring(1), s2.substring(1));
    }
}
