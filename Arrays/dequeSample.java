package Arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * dequeSample
 */
public class dequeSample {

    public static void main(String[] args) {
       int[] nums = {4,2,6,3,9};
       int k = 2;
       System.out.println(findWinningPlayer(nums, k));

    }
    public static int findWinningPlayer(int[] skills, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = skills.length;
        for(int indx = 0; indx < n; indx++)
            dq.add(indx);
        
        int cnt = 0, indx = -1, prev = Integer.MAX_VALUE;
        while(!dq.isEmpty()){
            if(cnt >= k || cnt >= n-1)
                break;
            int num1 = dq.poll();
            int num2 = dq.poll();
            if(skills[num1] > skills[num2] && prev > num2){
                dq.addFirst(num1);
                dq.addLast(num2);
                cnt++;
                indx = num1;
                prev = indx;
            }
            else{
                if(cnt < k && prev < num2)
                    cnt = 0;
                cnt++;
                indx = num2;
                prev = indx;
                dq.addFirst(num2);
                dq.addLast(num1);
            }
        }
        return indx;
    }
}