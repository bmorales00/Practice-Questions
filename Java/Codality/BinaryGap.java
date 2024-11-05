package com.brianprojects.Codality;

public class BinaryGap {

    public static int binaryGap(int n){

        var s = Integer.toBinaryString(n).toCharArray();
        int firstPointer = 0;
        int secondPointer = 0;
        int max = 0;

        while(secondPointer < s.length){
            if(s[firstPointer] == '0'){
                firstPointer++;
            }
            if((s[firstPointer] == '1' && s[secondPointer] == '1') && firstPointer != secondPointer){
                max = Math.max(max, secondPointer-firstPointer-1);
                firstPointer = secondPointer;
            }
            secondPointer++;
        }


        return max;
    }

}
