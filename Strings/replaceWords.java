package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * replaceWords
  */
 public class replaceWords {
 
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>(Arrays.asList("cat","bat","rat"));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }
    //TC: O(sentence.len() * words.len()) | SC: O(sentence.len())
    public static String replaceWords(List<String> dictionary, String sentence) {
        String ans = "";
        String[] words = sentence.split(" ");
        System.out.println(Arrays.toString(words));
        for(String currWord : words){
            String appendStr = currWord;

            for(String chkWord : dictionary){
                if(appendStr.startsWith(chkWord)){
                    if(chkWord.length() < appendStr.length())
                        appendStr = chkWord;
                }  
            }
            ans += appendStr + " ";
        }
        return ans;
    }
 }