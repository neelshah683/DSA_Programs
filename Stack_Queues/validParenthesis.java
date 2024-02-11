package Stack_Queues;

import java.util.Stack;
public class validParenthesis {
    
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')')
                if(st.isEmpty() || st.peek() != '(') return false;
                else   
                    st.pop();
            else if(ch == '}')
                if(st.isEmpty() || st.peek() != '{') return false;
                else
                    st.pop();
            else if(ch == ']') 
                if(st.isEmpty() || st.peek() != '[') return false;
                else
                    st.pop();    
            else
                st.push(ch);   
        }
        return st.isEmpty() ? true : false;
    }
}
