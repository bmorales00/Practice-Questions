package com.brianprojects.Leetcode.Stack;

import java.util.Stack;
//Time Complexity: O(s.length)+O(nums) || Space Complexity: O(word*nums)

public class DecodeStrings {
    public String decodeString(String s){
        if(s.length() == 0 ){
            return "";
        }
        Stack<StringBuilder> words = new Stack<>();
        StringBuilder word = new StringBuilder();
        StringBuilder nums = new StringBuilder();
        int  i = s.length()-1;

        while(i>=0){
            while(i>=0 && Character.isDigit(s.charAt(i))){
                nums.insert(0, s.charAt(i--));
            }
            if(nums.length() !=0){
                String finWord = word.toString();
                for(var j = 1; j<Integer.parseInt(nums.toString()); j++){
                    word.append(finWord);
                }
                nums =  new StringBuilder();
            }
            if(i>=0&& Character.isAlphabetic(s.charAt(i))){
                word.insert(0,s.charAt(i));
            }
            else if(i>=0&&s.charAt(i) == ']'){
                if(word.length()>0){
                    words.push(word);
                    word = new StringBuilder();
                }
                words.push(new StringBuilder());
            }
            else if(i>=0&&s.charAt(i) == '['){
                var extraWord = words.pop();
                while(!words.isEmpty() && extraWord.length()>0 && words.peek().length() >0){
                    word.append(extraWord);
                    extraWord = words.pop();
                }
                word.append(extraWord);
            }
            i--;
        }
        while(!words.isEmpty()){
            word.append(words.pop());
        }

        return word.toString();
    }
}
