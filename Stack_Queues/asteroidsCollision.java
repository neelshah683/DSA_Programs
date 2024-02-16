package Stack_Queues;
import java.util.Stack;
import java.util.Arrays;
public class asteroidsCollision {
    
    public static void main(String[] args) {
        int[] res = {-4,-1,10,2,-1,8,-9,-6,5,2};
        System.out.println(Arrays.toString(asteroidCollision(res)));
    }
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();
        int len = asteroids.length, flag = 1;

        for(int index = len-1; index >= 0; index--){
            if(!st.isEmpty() && st.peek() < 0 && asteroids[index] >= 0)
            {
                while(!st.isEmpty() && st.peek() < 0){
                    if(Math.abs(st.peek()) == asteroids[index])
                    {
                        st.pop();
                        flag = 0;
                        break; 
                    }
                    else if(asteroids[index] < Math.abs(st.peek()))
                    {
                        flag = 0;
                        break;
                    }
                    else{
                        st.pop();                     
                        flag = 1;
                    }
                }
                if(flag == 1)
                    st.push(asteroids[index]);
            } 
            else
                st.push(asteroids[index]);       
        }         
        int[] res = new int[st.size()];
        int i = 0;

        while(!st.isEmpty())
            res[i++] = st.pop();

        return res; 
    }       
}
