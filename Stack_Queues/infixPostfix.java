package Stack_Queues;

/**
 * infixPostfix
 */
import java.util.Stack;

public class infixPostfix {

    public static void main(String[] args) {
        String str = "(a-b/c)*(a/k-l)";
        System.out.println(infixToPostfix(str));
    }
    public static String infixToPostfix(String exp) {

        String res = "";
        Stack<Character> st = new Stack<>();

        for(char ch : exp.toCharArray())
        {
            if(Character.isLetterOrDigit(ch)) res += ch;
            else if(ch == '(') st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '(')
                    res += st.pop();
                st.pop();
            }
            else {
                while(!st.isEmpty() && chkPrecedence(st.peek()) >= chkPrecedence(ch)) 
                        res += st.pop();
                st.push(ch);
            }              
        }
        while(!st.isEmpty())
            res += st.pop();
        return res;
    }
    public static int chkPrecedence(char ch)
    {
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        return -1;
    }
    
}