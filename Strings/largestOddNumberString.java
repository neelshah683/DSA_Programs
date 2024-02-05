package Strings;

public class largestOddNumberString {
    
    public static void main(String[] args) {
        String num = "52";
        System.out.println(largestOddNumber(num));
    }
    public static String largestOddNumber(String num) {
        int chk = -1;
        for(int index = num.length()-1; index >= 0; index--)
        {
            int lastDigit = num.charAt(index) - '0';
            if(lastDigit % 2 == 1)
            {
                chk = index;
                break;
            }
        }
        return (chk == -1) ? "" : num.substring(0, chk + 1);
    }
}
