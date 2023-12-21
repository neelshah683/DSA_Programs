public class sumdigitsRecursion {
    
    public static void main(String[] args) {
        
        int n = 22;
        int ans = sumDigitsRecur(n);
        System.out.println(ans);
    }
    static int sumDigitsRecur(int n)
    {
        if(n == 0)
            return 0;
        
        int l_digit = n % 10;
        return l_digit + sumDigitsRecur(n/10);
    }
}
