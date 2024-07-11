package Strings;

import java.util.Stack;

public class revSubsbtwParanthesis {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("ta()usw((((a))))"));
    }
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";

        for(char ch : s.toCharArray()){
            if(ch == '(')
                st.push(ch);
            else if(ch == ')'){
                
                String temp = "";
                while(st.peek() != '('){
                    temp += st.pop();
                }

                st.pop();

                if(!st.isEmpty())
                    for(char ch2 : temp.toCharArray()){
                        st.push(ch2);
                    }
                else
                    ans += temp;
            }
            else{
                if(!st.isEmpty())
                    st.push(ch);
                else
                    ans += ch;                
            }
        }

        return ans;
    }
    
}


