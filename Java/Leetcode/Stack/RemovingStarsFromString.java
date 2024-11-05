package com.brianprojects.Leetcode.Stack;

public class RemovingStarsFromString {

    //Time Complexity: O(n) || Space Complexity: O(n)
    public String removeStars(String s){
        if(s == null){return "";}
        StringBuilder res  = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch == '*'){
                res.setLength(res.length()-1);
            }
            else{
                res.append(ch);
            }
        }
        return  res.toString();
    }
}
