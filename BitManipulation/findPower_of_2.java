public class findPower_of_2 {
    
    public static void main(String[] args) {
        
        int n = 0;

        boolean ans = (n & (n-1)) == 0;
        if(ans)
            System.out.println("Is is Power of 2");
        else
            System.out.println("It is not power of 2");

    }
}
