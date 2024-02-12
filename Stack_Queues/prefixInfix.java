package Stack_Queues;

import java.util.Stack;

public class prefixInfix {
    
    public static void main(String[] args) {
        String str = "*-a/bc-/akl";
        System.out.println(prefixToInfixConversion(str));
    }
    public static String prefixToInfixConversion(String exp) {
        Stack<String> st = new Stack<>();
        int len = exp.length()-1;
        for(int i=len; i >= 0; i--)
        {
            if(Character.isLetter(exp.charAt(i)))
                st.push(""+exp.charAt(i));
            else {
                String s1 = st.pop();
                String s2 = st.pop();
                st.push("("+s1+exp.charAt(i)+s2+")");
            }
        }
        return st.peek();
    }
}
