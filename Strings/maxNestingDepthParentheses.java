package Strings;

import java.util.Stack;

public class maxNestingDepthParentheses {
    
    public static void main(String[] args) {
        String str = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(str));
    }
    public static int maxDepth1(String s) {
        int cnt = 0, maxCnt = Integer.MIN_VALUE;
    
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            }
            else if(ch == ')')
                cnt--;
        }
        return maxCnt == Integer.MIN_VALUE ? cnt : maxCnt;
    }
    //Using Stack
    public static int maxDepth(String s) {
        int maxCnt = 0;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
                st.push(ch);
            else if(ch == ')')
            {
                maxCnt = Math.max(maxCnt, st.size());
                st.pop();
            }
        }
        return maxCnt;
    }
}
