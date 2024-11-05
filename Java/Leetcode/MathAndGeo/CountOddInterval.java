package com.brianprojects.Leetcode.MathAndGeo;

public class CountOddInterval {
    //Time Complexity:O(1) || Space Complexity:O(1)
    public int countOdds(int low, int high){
        if(low <0 || high <0){return -1;}
        if(low%2!=0){low--;}
        if(high%2!=0){high++;}

        return (high-low)/2;
    }
}
