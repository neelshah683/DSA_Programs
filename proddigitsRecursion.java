public class proddigitsRecursion {
    
    public static void main(String[] args) {
        int n = 000;
        int ans = prodDigits(n);
        System.out.println(ans);
        
    }
    static int prodDigits(int n)
    {
        if(n%10 == n)
            return n;
        
        int l_digit = n % 10;
        return l_digit * prodDigits(n/10);
    }
}
