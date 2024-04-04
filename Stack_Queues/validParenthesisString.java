package Stack_Queues;
import java.util.Stack;
public class validParenthesisString {
    public static void main(String[] args) {
        String str = "*(((***)))";
        System.out.println(checkValidString(str));
    }
    public static boolean checkValidString(String s) {
        Stack<Integer> leftBraces = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int len = s.length();
        for(int indx = 0; indx < len; indx++){
            if(s.charAt(indx) == ')'){
                if(!leftBraces.isEmpty())   leftBraces.pop();
                else if(!star.isEmpty())    star.pop();
                else    return false;
            }
            else if(s.charAt(indx) == '(')  leftBraces.push(indx);
            else    star.push(indx);
        }
        while(!leftBraces.isEmpty()){
            if(star.isEmpty())  return false;
            else if(leftBraces.peek() < star.peek()){
                leftBraces.pop();
                star.pop();
            }
            else
                return false;
        }
        return true;
    }
}
