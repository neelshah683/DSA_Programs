public class Nth_MagicNumber {
    
    public static void main(String[] args) {
        
        int n = 4;
        int ans = 0, base = 5;

        while(n > 0)
        {
            int last = n & 1;
            ans += last * base;
            base = base * 5;
            n = n >> 1;
        }

        System.out.println(ans);
    }
}
