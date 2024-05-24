import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class maxScoreWords {
    
    public static void main(String[] args) {
        String[] words = {"dog", "dad", "good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words, letters, score));
    }
     public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n1 = words.length;
        int n2 = letters.length;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int indx = 0; indx < n2; indx++)   
            map.put(letters[indx], map.getOrDefault(letters[indx], 0) + 1); 

        int maxScore = 0;
        for(int indx = 1; indx < (1 << n1); indx++){
            List<String> strWords = new ArrayList<>();
            HashMap<Character, Integer> defaultMap = new HashMap<>(map);
            for(int indx2 = 0; indx2 < n1; indx2++){
                if((indx & (1 << indx2)) > 0){
                    strWords.add(words[indx2]);
                }
            }
            System.out.println(strWords);
            maxScore = Math.max(maxScore, chkWords(strWords, defaultMap, score));
            System.out.println(maxScore);
        }
        return maxScore;
    }
    public static int chkWords(List<String> words, HashMap<Character, Integer> map, int[] score){
        int currScore = 0;
        for(int indx = 0; indx < words.size(); indx++){
            String currWord = words.get(indx);
            for(int indx2 = 0; indx2 < currWord.length(); indx2++){
                char currLetter = currWord.charAt(indx2);
                if(map.containsKey(currLetter) && map.get(currLetter) > 0){
                    map.put(currLetter, map.get(currLetter)-1);
                    currScore += score[currLetter-'a'];
                }
                else
                    return 0;
            }
        }
        return currScore;
    }
}
