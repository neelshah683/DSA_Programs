package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

 class WordLadder{
    String first;
    int second;
    WordLadder(String first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class WordLadder_1 {
    public static void main(String[] args) {
        String beginWord = "leet", endWord = "code";
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
            
        Queue<WordLadder> q = new LinkedList<>();
        q.add(new WordLadder(beginWord, 1));

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++)
            set.add(wordList.get(i));
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int seconds = q.peek().second;
            q.remove();

            if(word.equals(endWord)==true)
                return seconds;
            
            for(int i=0; i<word.length(); i++)
            {                
                for(char ch = 'a'; ch<='z'; ch++)
                {               
                   char[] charArray = word.toCharArray();
                   charArray[i] = ch;
                   String replaceWord  = String.valueOf(charArray);
                    if(set.contains(replaceWord))
                    {
                        q.add(new WordLadder(replaceWord, seconds + 1));
                        set.remove(replaceWord);
                    }
                }
                
            }
        }
        return 0;
    }
}
