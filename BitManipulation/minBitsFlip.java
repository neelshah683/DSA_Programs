public class minBitsFlip {
    
    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(minBitFlips(start, goal));
    }
    public static int minBitFlips(int start, int goal) {
        int diffBits = start ^ goal;
        int cnt = 0;
        while(diffBits > 0){
            if((diffBits & 1) == 1)
                cnt++;
            diffBits = diffBits >> 1;   
        }
        return cnt;
    }
}
