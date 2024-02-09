public class setRighMostUnsetBit {
    
    public static void main(String[] args) {
        int N = 5;
        System.out.println(setBits(N));
    }
    public static int setBits(int N){
        if((N & (N+1)) == 0)
            return N;
        return N | N+1;
}
}
