import java.util.Arrays;

public class twoNumWithOddOccurrences {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 2, 4};
        System.out.println(Arrays.toString(twoOddNum(nums)));   
    }
    public static int[] twoOddNum(int []arr){
        int xor = 0;
        for(int var : arr)
            xor ^= var;
        
        int num = xor & ~(xor-1); // ~ -> does 2's complement of a number

        int zero = 0, one = 0;
        for(int var : arr)
            if((var & num) != 0)
                one ^= var;
            else    
                zero ^= var;
        return (one > zero) ? new int[] {one, zero} : new int[] {zero, one};   
    }
}
