package com.brianprojects.LeetQues75.DynamProg1D;

import java.util.List;

public class WordBreak {
    /*
    Given a string s and a dictionary of strings wordDict,
    return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.

     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        int wordLength = s.length();
        boolean[] dp = new boolean[wordLength];

        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[wordLength - 1];
    }

}
/*
boolean[] boolList = new boolean[s.length()];
        StringBuilder str = new StringBuilder(s.length());
        for(var i = 0; i < s.length(); i++){
            str.append(s.charAt(i));
            if(wordDict.contains(str.toString())){
                boolList[i] = true;
            }
            for(var j = i+1; j<s.length(); j++){
                str.append(s.charAt(j));
                if(wordDict.contains(str.toString())){
                    boolList[j] = true;
                }
            }
            str.replace(0, str.length(), "");
        }

        return boolList[s.length()-1];
 */
/*
//My first attempt
public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] boolList = new boolean[s.length()];
        var pointer = 0;
        String str = "";
        while(pointer < s.length()){
            str+=s.charAt(pointer);
            if(wordDict.contains(str)){
                boolList[pointer] = true;
                str = "";
            }
            pointer++;
        }
        return boolList[s.length()-1];
    }
 */





//
//        for(var i =0; i<s.length(); i++){
//            str += s.charAt(i);
//            if(wordDict.contains(str)){
//                boolean word = true;
//                boolList[i] = word;
//                for(var j = i+1; j<s.length(); j++){
//                    str+=s.charAt(j);
//                    if(wordDict.contains(str)){
//                        boolList[j] = word;
//                    }
//                }
//                str = "";
//            }
//
//        }
//        return boolList[s.length()-1];
