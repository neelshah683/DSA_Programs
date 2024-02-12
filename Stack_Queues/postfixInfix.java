package Stack_Queues;
import java.util.Stack;

public class postfixInfix {
    public static void main(String[] args) {
        String str = "ab+c+";
        System.out.println(postToInfix(str));
    }
    public static String postToInfix(String postfix) {
        Stack<String> st = new Stack<>();
        for(char ch : postfix.toCharArray())
        {
            if(Character.isLetter(ch))
                st.push(""+ch);
            else {
                String s1 = st.pop();
                String s2 = st.pop();
                st.push("("+s2+ch+s1+")");
            }
        }
        return st.peek();
    }
}
