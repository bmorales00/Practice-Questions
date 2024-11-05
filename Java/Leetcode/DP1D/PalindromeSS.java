package com.brianprojects.Leetcode.DP1D;

//Manachers Algorithm
//Time Complexity: O(n) | Space Complexity: O(n);
public class PalindromeSS {
    public int countSubStrings(String s){

        int maxCount = s.length();

        char[] palBank = new char[(s.length()*2)+1];
        int[] palCount = new int[(s.length()*2)+1];

        for(var i = 0; i<palBank.length; i++){
            palBank[i] = i%2==0?'|':s.charAt(i/2);
        }
        int rBound = 0;
        int mid = 0;
        for(var i =1;i<palBank.length-1; i++){
            int r = i+1;
            int l = i-1;

            while(l>=0 && r<palBank.length && palBank[l] == palBank[r]){
                palCount[i]++;
                r++;
                l--;
            }
            if(i+palCount[i] > rBound){
                mid = i;
                rBound = r-1;
            }

            maxCount+=palCount[i]/2;
        }

        return maxCount;
    }
}
