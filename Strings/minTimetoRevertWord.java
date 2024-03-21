package Strings;

public class minTimetoRevertWord {
    
    public static void main(String[] args) {
        String word = "abacaba";
        int k = 3;
        System.out.println(minimumTimeToInitialState(word, k));
    }
    public static int minimumTimeToInitialState(String word, int k) {
        int[] lpsArr = computeKMP(word);
        int len = word.length();
        int maxLps = lpsArr[len - 1];

        while(maxLps > 0 && ((len-maxLps) % k) != 0){
            maxLps = lpsArr[maxLps - 1];
        }

        return (len-maxLps) % k == 0 ? (len-maxLps) / k : (int)Math.ceil(len/k) + 1;
    }
    public static int[] computeKMP(String word){
        int len = word.length();
        int[] lpsArr = new int[len];
        for(int indx = 1; indx < len; indx++){
            int prevIndx =  lpsArr[indx - 1];

            while(prevIndx > 0 && word.charAt(indx) != word.charAt(prevIndx))
                prevIndx = lpsArr[prevIndx - 1];

            lpsArr[indx] = prevIndx + (word.charAt(indx) == word.charAt(prevIndx) ? 1 : 0);
        }
        return lpsArr;
    }
}
