package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class PairS{
    char ch;
    int fq;
    PairS(char c, int f){
        this.ch = c;
        this.fq = f;
    }
}
public class replaceQuestionMarks {
    
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxy??";
        System.out.println(minimizeStringValue(str));
    }
    public static String minimizeStringValue(String s) {        
        int len = s.length();
        int[] freq = new int[26];
        List<Character> storeMinCh = new ArrayList<>();
        PriorityQueue<PairS> pq = new PriorityQueue<>((p1, p2) -> p1.fq == p2.fq ? p1.ch - p2.ch : p1.fq - p2.fq);
        
        StringBuilder sb = new StringBuilder(s);
        
        for(char ch: s.toCharArray())
            if(ch != '?')   freq[ch-'a']++;

        for(int indx = 0; indx < 26; indx++)
            pq.add(new PairS((char)(indx + 'a'), freq[indx]));

        for(char ch: s.toCharArray()){
            if(ch == '?'){
                PairS p = pq.poll();

                storeMinCh.add(p.ch);

                pq.add(new PairS(p.ch, p.fq + 1));
            }
        }
        Collections.sort(storeMinCh);
        int ini = 0;
        for(int indx = 0; indx < len; indx++){
            if(sb.charAt(indx) == '?'){
                sb.setCharAt(indx, storeMinCh.get(ini++));
            }
        }
        return sb.toString();
    }
}
