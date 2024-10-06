package Strings;

import java.util.Arrays;

/**
 * sentenceSimilarity3
 */
public class sentenceSimilarity3 {

    public static void main(String[] args) {
        String s1 = "My name is Haley";
        String s2 = "My Haley";
        System.out.println(areSentencesSimilar(s1, s2));
    }
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {     

        if(sentence1.length() < sentence2.length()){
            String temp = "";
            temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");

        System.out.println(Arrays.toString(w1));
        System.out.println(Arrays.toString(w2));

        int n1 = w1.length, n2 = w2.length;

        int pt1 = 0, pt2 = n1-1;
        int pt3 = 0, pt4 = n2-1;

        while(pt1 < n1 && pt3 < n2 && w1[pt1].equals(w2[pt3])){
            pt1++;
            pt3++;
        } 

        while(pt3 >= pt4 && w1[pt2].equals(w2[pt4])){
            pt2--;
            pt4--;
        }

        return (pt4 < pt3);
    }
}