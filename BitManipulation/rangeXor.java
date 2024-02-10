public class rangeXor {
    public static void main(String[] args) {
        int L = 3, R = 9;
        System.out.println(findXOR(L, R));
    }
    public static int findXOR(int L, int R){
        return calcXor(R) ^ calcXor(L-1);        
    }
    public static int calcXor(int a)
    {
        if(a % 4 == 0) return a;
        if(a % 4 == 1) return 1;
        if(a % 4 == 2) return a+1;
        // if(a % 4 == 3)  return 0;
        return 0;  
    }
}
