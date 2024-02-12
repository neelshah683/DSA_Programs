package Stack_Queues;
import java.util.Stack;

public class postfixPrefix {
    
    public static void main(String[] args) {
        String str = "abc/-ak/l-*";
        System.out.println(postfixToPrefix(str));
    }
    public static String postfixToPrefix(String exp) {
        
        Stack<String> st = new Stack<>();
        for(char ch : exp.toCharArray())
        {
            if(Character.isLetter(ch))
                st.push(""+ch);
            else {
                String s1 = st.pop();
                String s2 = st.pop();
                st.push(""+ch+s2+s1);
            }
        }
        return st.peek();
    }
}
