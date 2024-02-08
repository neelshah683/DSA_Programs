
public class divTwoIntegers {
    public static void main(String[] args) {
        int dividend = 7, divisor = -3;
        System.out.println(divide(dividend, divisor));
    }
    public static int divide(int dividend, int divisor) {

        if(dividend == -1 << 31 && divisor == -1) return (1 << 31) - 1;
        if(dividend == -1 << 31 && divisor == 1) return -(1 << 31);
 
        int res = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while(a - b >= 0)
        {
            int x = 0;
            while(a - (b << 1 << x) >= 0)
                 x++;
             res += 1 << x;
             a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
     }
}
