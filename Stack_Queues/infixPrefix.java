package Stack_Queues;
import java.util.Stack;

public class infixPrefix {
    public static void main(String[] args) {
        String str = "(a-b/c)*(a/k-l)";
        String s = revStr(str);
        System.out.println(infixToPrefix(s));
    }
    public static String revStr(String exp)
    {
        StringBuilder str = new StringBuilder(exp);
        str.reverse();
        char[] ch = str.toString().toCharArray();
        for(int i=0; i<ch.length; i++)
            if(ch[i] == '(')
                ch[i] = ')';
            else if(ch[i] == ')')
                ch[i] = '(';
        return String.valueOf(ch);
    }
    public static String infixToPrefix(String exp) {
        String res = "";
        Stack<Character> st = new Stack<>();
        for(char ch: exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)) res += ch;
            else if(ch == '(') st.push(ch);
            else if(ch == ')') {
                while(st.peek() != '(')
                    res += st.pop();
                st.pop();
            }
            else {
                while(!st.isEmpty() && chkPrecedence(st.peek()) >= chkPrecedence(ch)) {res += st.pop();}
                st.push(ch);
            }
        }
        while(!st.isEmpty())    
            res += st.pop();
        StringBuilder s = new StringBuilder(res);
        return s.reverse().toString();
    }
    public static int chkPrecedence(char ch)
    {
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        return -1;
    }
}
