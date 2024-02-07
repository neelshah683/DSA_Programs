package Strings;

public class strToInteger_ATOI {
    public static void main(String[] args) {
        String str = "  -42";
        System.out.println(myAtoi(str));
    }
    public static int myAtoi(String s) {
        s = s.trim();

        if(s.isEmpty())
            return 0;
        
        int len = s.length();
        int index = 0, sign = 1;
        if(s.charAt(0) == '-')
        {
            sign = -1;
            index++;
        }

        if(s.charAt(0) == '+')
            index++;
        
        int result = 0;
        while(index < len && Character.isDigit(s.charAt(index)))
        {
            int digit = s.charAt(index) - '0';

            if(result > (Integer.MAX_VALUE - digit) / 10)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result  = result * 10 + digit;
            index++;
        }
        return result * sign;
    }
}
