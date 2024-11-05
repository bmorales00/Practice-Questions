package com.brianprojects.Leetcode.DP1D;

//Manachers Algorithm
//Time Complexity: O(n) | Space Complexity: O(n);

public class LPS {
    public String longestPalindrome(String s){

        StringBuilder res = new StringBuilder();
        int maxL = 0;
        int maxR = 0;
        char[] palBank = new char[(s.length()*2)+1];
        int[] strCount = new int[(s.length()*2)+1];

        for(var i = 0; i<palBank.length; i++){
            palBank[i] = i%2 ==0?palBank[i] = '|':s.charAt(i/2);
        }

        int mid = 0;
        int rBound = 0;
        for(var i = 1; i<palBank.length-1; i++){
            //int mirror = (2*mid)-1;
            int r = i+1;
            int l = i-1;
            while(l >=0 && r<palBank.length && palBank[l] == palBank[r]){
                r++;
                l--;
                strCount[i]++;
            }
            if(i+strCount[i] > rBound){
                //mid = i;
                rBound = r-1;
            }
            if((r-1 - l+1) > (maxR - maxL)){
                maxR = r-1;
                maxL = l+1;
            }
        }

        for(var i = maxL/2; i<maxR/2; i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
