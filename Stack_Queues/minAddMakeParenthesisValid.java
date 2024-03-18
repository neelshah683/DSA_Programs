package Stack_Queues;

import java.util.Stack;
public class minAddMakeParenthesisValid {
    
    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
        if(s.length() == 1) return 1;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')')
                if(st.isEmpty() || st.peek() != '(') 
                    st.push(ch);
                else   
                    st.pop();
            else
                st.push(ch);   
        }
        return st.isEmpty() ? 0 : st.size();
    }
}
