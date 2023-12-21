package Graph_Technique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder_2 {
    public static void main(String[] args) {
        String startWord = "bat", endWord = "coz";
        String[] wordList = {"pat", "bot", "pot", "poz", "coz"};
        System.out.println(findSequences(startWord, endWord, wordList));
    }
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList)
            set.add(word);
        set.remove(startWord);

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(startWord);
        q.add(list);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int level = 0;

        while(!q.isEmpty())
        {
            ArrayList<String> vec = q.peek();
            q.remove();

            if(vec.size() > level)
            {
                level++;
                for(String it : usedOnLevel)
                    set.remove(it);
            }

            String word = vec.get(vec.size()-1);
            if(word.equals(targetWord))
            {
                if(ans.size() == 0)
                    ans.add(vec);
                else if(ans.get(0).size() == vec.size())
                    ans.add(vec);
            }
            for(int i=0; i<word.length(); i++)
            {
                for(char c = 'a'; c<='z'; c++)
                {
                    char[] charArray = word.toCharArray();
                    charArray[i] = c;
                    String temp = new String(charArray);
                    if(set.contains(temp))
                    {
                        vec.add(temp);
                        q.add(new ArrayList<String>(vec));
                        vec.remove(vec.size()-1);
                        usedOnLevel.add(temp);
                    }
                }
            }
        }
        return ans;
    }
}
