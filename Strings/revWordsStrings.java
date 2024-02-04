package Strings;

public class revWordsStrings {
    public static void main(String[] args) {
        String s = "  the sky  is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String res = "";
        for(int i=words.length-1; i>=0; i--)
            res += words[i]+" ";
        return res.trim();
    } 
}
