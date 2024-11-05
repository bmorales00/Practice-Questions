package com.brianprojects.Leetcode.MathAndGeo;

public class PalindromeNumber {
    //Time Complexity: O(1) || Space Complexity: O(1)
    public boolean isPalindrome(int x){
        if(x < 0) {
            return false;
        }
        int y = x;
        int z = 0;
        while(y > 0){
            z = z * 10 + y % 10;
            y = y / 10;
        }
        return x == z;
    }
}
