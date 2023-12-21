public class fiboRecurstion {
    
    public static void main(String[] args) {
        
        int n = 4;
        int ans = fibonacciSeq(n);
        System.out.println(ans);
    }
    static int fibonacciSeq(int n)
    {
        if(n <= 1)
            return n;
        
        return fibonacciSeq(n-1) + fibonacciSeq(n-2);
    }
}
