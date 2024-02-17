package Stack_Queues;

public class removeKdigits {
    
    public static void main(String[] args) {
        
    }
    public String removeKdigits(String num, int k) {
        int len = num.length();

        if(len == k) return "0";

        Stack<Character> st = new Stack<>();

        for(int index = 0; index < len; index++){

            while(!st.isEmpty() && num.charAt(index) < st.peek() && k > 0){
                st.pop();
                k--;
            }
            st.push(num.charAt(index));
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty())
            res.append(st.pop());

        res.reverse();

        while(res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        return res.toString();
    }
}
