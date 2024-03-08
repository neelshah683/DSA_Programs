package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class maximumSumCombinations {
    
    public static void main(String[] args) {
        int N = 4;
        int K = 3;
        int A [ ] = {1, 4, 2, 3};
        int B [ ] = {2, 5, 1, 6};
        System.out.println(maxCombinations(N, K, A, B));
    }
    public static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int index1 = N-1; index1 >= 0; index1--){
            for(int index2 = N-1; index2 >= 0; index2--){
                int sum = A[index1] + B[index2];
                
                if(pq.size() < K)
                    pq.add(sum);
                else if(pq.peek() < sum){
                    pq.poll();
                    pq.add(sum);
                }
                else
                    break;
            }
        }
        while(!pq.isEmpty())
            ans.add(pq.poll());
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
}
