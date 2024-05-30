public class prefixXorTripletsEqualsXor {
    
    public static void main(String[] args) {
        
        int[] arr = {2, 3, 1, 6, 7};
        System.out.println(countTriplets(arr));
    }
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int[] prefix = new int[n+1];
        for(int indx = 0; indx < n; indx++)
            prefix[indx + 1] = prefix[indx] ^ arr[indx];
        
        for(int indx1 = 0; indx1 < n; indx1++){
            for(int indx2 = indx1+1; indx2 <= n; indx2++){
                    if(prefix[indx1] == prefix[indx2])
                        cnt += indx2 - indx1 - 1;
            }
        }
        return cnt;
    }
}
