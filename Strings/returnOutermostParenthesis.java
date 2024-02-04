package Strings;

public class returnOutermostParenthesis {
    
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
    public static String removeOuterParentheses(String s) {
        int open = 0;
        String res = new String();
        for(char ch : s.toCharArray())
        {
            if(ch == '(' && open++ > 0) res += ch;
            if(ch == ')' && open-- > 1) res += ch;
        }
        return res;
    }
}
