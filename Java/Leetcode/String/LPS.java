package com.brianprojects.Leetcode.String;

public class LPS {
    /*
    Given a string s, return the longest palindromic substring in s.
     */
    public String longestPalindromic(String s) {
        if(s.length() == 1){
            return s;
        }
        else if(s.length() == 2){
            return s.charAt(0)== s.charAt(1)?s: String.valueOf(s.charAt(0));
        }
        String word = "";
        int longestWord = 0;

        for(var i = 1; i<s.length()-1; i++){
            int left = i-1;
            int right = i+1;
            String str = "" + s.charAt(i);
            if(s.charAt(left) == s.charAt(i) && s.charAt(right) != s.charAt(i)){
                str+=s.charAt(left);
            }
            if(s.charAt(i) == s.charAt(right)){
                str += s.charAt(right);
                if(right != s.length()-1){
                    right+=1;
                }

            }

            while(left >=0 && right <=s.length() -1){
                if (str.length() == s.length()){
                    break;
                }
                if(s.charAt(left) == s.charAt(right)){
                    str = s.charAt(left--) + str + s.charAt(right++);
                }
                else{
                    break;
                }
            }
            if(str.length() > longestWord){
                longestWord = str.length();
                word = str.toString();
            }
        }
        return word;

    }
}
