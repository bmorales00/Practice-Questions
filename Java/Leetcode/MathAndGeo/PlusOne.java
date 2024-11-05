package com.brianprojects.Leetcode.MathAndGeo;

public class PlusOne {
    //Time Complexity: O(1) || // Space Complexity: O(n)
    public int[] plusOne(int[] digits){
        if(digits == null){return new int[0];}
        int carry =-1;
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i]%9 == 0 && digits[i]>0){
                if(i == 0){
                    carry = 1;
                }
                digits[i] = 0;
            }
            else{
                digits[i]+=1;
                return digits;
            }
        }
        int[] res = new int[digits.length+1];
        res[0] = carry;
        return res;
    }
}
