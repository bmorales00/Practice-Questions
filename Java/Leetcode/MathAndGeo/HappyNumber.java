package com.brianprojects.Leetcode.MathAndGeo;

public class HappyNumber {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public boolean isHappy(int n){
        if(n<=0){return false;}
        StringBuilder res = new StringBuilder();
        res.append(n);
        while(true){
            if(res.length() == 1 && res.charAt(0) == '1'){
                return true;
            }
            if(res.length() == 1 && Character.getNumericValue(res.charAt(0))<=4){
                return false;
            }
            int soFar = 0;
            for(int i = 0; i<res.length(); i++){
                int num = Character.getNumericValue(res.charAt(i));
                soFar+=(num*num);
            }
            res.replace(0,res.length(), Integer.toString(soFar));
        }
    }
}
