package DynamicProgramming;

public class fibonacciSequenceTabulation {
    
    public static void main(String[] args) {
        
        int prev = 1, prev2 = 0, n=4;
        for(int i=2; i<=n; i++)
        {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
    }
}
