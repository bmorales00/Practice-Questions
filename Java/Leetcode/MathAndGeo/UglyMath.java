package com.brianprojects.Leetcode.MathAndGeo;

public class UglyMath {
    //Time Complexity: O(1) || Space Complexity: O(1)
    public boolean isUgly(int n){
        if(n ==1){return true;}
        if(n<=0){return false;}

        int x = n;
        while(x>1){
            if(x%2==0){
                x/=2;
            }
            else if(x%3 == 0){
                x/=3;
            }
            else if(x%5 ==0){
                x/=5;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
