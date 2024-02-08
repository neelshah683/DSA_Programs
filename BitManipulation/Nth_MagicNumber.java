public class Nth_MagicNumber {
    
    public static void main(String[] args) {
        
        int n = 6, base = 5, ans = 0;
        while(n > 0)
        {
            int last = n & 1;
            ans += last * base;
            base *= 5;
            n = n >> 1;
        }
        System.out.println(ans);
    }
}
