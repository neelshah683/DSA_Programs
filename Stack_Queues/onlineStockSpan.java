package Stack_Queues;

import java.util.Stack;
import HashMap.Pair;

/**
 * onlineStockSpan
 */
class PairStockSpan{
    int first, second;
    PairStockSpan(int x , int y){
        this.first = x;
        this.second = y;
    }
}
public class onlineStockSpan {

    static Stack<PairStockSpan> st;
    static Stack<Pair<Integer, Integer>> st2;

    public onlineStockSpan(){
        st = new Stack<>();
        st2 = new Stack<>();

    }
    public static void main(String[] args) {
        onlineStockSpan o1 = new onlineStockSpan();
        System.out.println(next(100));
        System.out.println(next(80));
        System.out.println(next(60));
        System.out.println(next(70));
        System.out.println(next(60));
        System.out.println(next(75));
        System.out.println(next(85));
    }

    //Using Inbuilt Pair Class 
    //need to import this to use it ---->> import javafx.util.Pair;

    public static int next1(int price) {
        int val = 0;
        while(!st2.isEmpty() && price >= st2.peek().getKey())
            val += st2.pop().getValue();
        st2.push(new Pair<>(price , val + 1));
        return st2.peek().getValue();
    }
    //Using Customized Pair Class
    public static int next(int price) {
        int val = 0;
        while(!st.isEmpty() && price >= st.peek().first)
            val += st.pop().second;
        st.push(new PairStockSpan(price , val + 1));
        return st.peek().second;
    }
}
