package Stack_Queues;

import java.util.Stack;

public class prefixPostfix {
    public static void main(String[] args) {
        String str = "*-a/bc-/akl";
        System.out.println(preToPost(str));
    }
    public static String preToPost(String s) {
        
        Stack<String> st = new Stack<>();
        int len = s.length()-1;
        for(int i = len; i >= 0; i--)
        {
            if(Character.isLetter(s.charAt(i)))
                st.push(""+s.charAt(i));
            else {
                String s1 = st.pop();
                String s2 = st.pop();
                st.push(""+s1+s2+s.charAt(i));
            }  
        }
        return st.peek();
    }
}
