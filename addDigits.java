public class addDigits{

    public static int add_Digits(int num) {

        if(num == 0)
            return 0;

        int l_digit = num % 10;
        int ans = l_digit + add_Digits(num/10);

        return ans < 10? ans : add_Digits(ans);
    }
    public static void main(String[] args) {
        int num = 38;
        int ans = add_Digits(num);
        System.out.println(ans);
    }
}