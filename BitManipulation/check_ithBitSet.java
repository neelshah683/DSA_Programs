public class check_ithBitSet {
    
    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(isKthBitSet(n, k));    
    }
    public static boolean isKthBitSet(int n, int k) {
        return ((n >> k-1) & 1) == 1 ? true : false;
    }
}
