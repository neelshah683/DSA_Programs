import java.util.Arrays;

public class UniqueElement {
    
    public static void main(String[] args) {
        
        int[] arr = {30000, 500, 100, 30000, 100, 30000, 100};
        int unique = 0;
        for(int n : arr)
        {
            unique ^= n;
        }
        System.out.println("Unique = "+unique);
    }
}
