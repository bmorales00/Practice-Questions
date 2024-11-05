package com.brianprojects.Leetcode.Greedy;

public class ValidParenthesisString {
    //Time Complexity: O(n) || Space Complexity: O(1)
    public boolean checkValidString(String s){
        if(s.length()==0){return false;}

        int openMax = 0;
        int openMin = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){openMax++; openMin++;}
            else if(ch == ')'){openMax--;openMin--;}
            else if(ch == '*'){openMax++; openMin--;}
            if(openMax <0){return false;}
            openMin =Math.max(openMin,0);
        }
        return openMin ==0;
    }
}
