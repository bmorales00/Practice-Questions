package com.brianprojects.Leetcode.Graphs;

public class AlienDictionary {
    //Time Complexity: O(n*w) || Space Complexity:O(1)
    public boolean isAlienDictionary(String[] words, String order) {
        if(words.length == 1){return true;}
        for(int i = 1; i<words.length; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            if(order.indexOf(word1.charAt(0)) > order.indexOf(word2.charAt(0))){return false;}
            if(word1.charAt(0) == word2.charAt(0) && !isSorted(order,word1, word2)){return false;}
        }
        return true;
    }

    private boolean isSorted(String order, String word1, String word2) {
        int i = 0;
        int j = 0;
        while(i<word1.length() && j <word2.length()){
            int val1 = order.indexOf(word1.charAt(i));
            int val2 = order.indexOf(word2.charAt(j));
            if(val1 > val2){return false;}
            i++;j++;
        }
        int min = Math.min(word1.length(), word2.length());

        return word1.length() <= word2.length() || order.indexOf(word1.charAt(min-1)) < order.indexOf(word2.charAt(min-1));
    }
}
/*
int[] word1 = new int[26];
//        int[] word2 = new int[26];
//        for(int i = 0; i<leftWord.length(); i++){
//            word1[order.indexOf(leftWord.charAt(i))]++;
//        }
//        for(int i = 0; i<rightWord.length(); i++){
//            word2[order.indexOf(rightWord.charAt(i))]++;
//        }
 */