public class check_ithBitSet {
    
    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(isKthBitSet(n, k));    
    }
    public static boolean isKthBitSet(int n, int k) {
        //can also e checked as: (index & (1 << index2)) > 0
        return ((n >> k-1) & 1) == 1 ? true : false;
    }
}
