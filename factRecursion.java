public class factRecursion {
    
    public static void main(String[] args) {

        int num = 4;
        
        int ans = fact(num);
        System.out.println(ans);
    }
    static int fact(int n)
    {
        if(n==1)
            return 1;

        return n * fact(n-1);
    }
}
