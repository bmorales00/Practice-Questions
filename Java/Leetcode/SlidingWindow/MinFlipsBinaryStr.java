package com.brianprojects.Leetcode.SlidingWindow;

public class MinFlipsBinaryStr {
    public int minFlips(String s){
        StringBuilder oneAlt = new StringBuilder(s.length());
        StringBuilder zeroAlt = new StringBuilder(s.length());
        StringBuilder str = new StringBuilder(s);
        int minFlips;
        int oneAltFlips = 0;
        int zeroAltFlips = 0;

        oneAlt.append("1");
        zeroAlt.append("0");

        for(int i = 1; i<str.length()*2;i++){
            oneAlt.append(oppositeChar(oneAlt,oneAlt.length()-1));
            zeroAlt.append(oppositeChar(zeroAlt,zeroAlt.length()-1));
        }

        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) != oneAlt.charAt(i)){oneAltFlips++;}
            else if(str.charAt(i) != zeroAlt.charAt(i)){zeroAltFlips++;}
        }

        minFlips = Math.min(oneAltFlips,zeroAltFlips);

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(0) != oneAlt.charAt(i)){oneAltFlips--;}
            else if(str.charAt(0) != zeroAlt.charAt(i)){zeroAltFlips--;}
            str.append(str.charAt(0));
            str.delete(0,1);

            if(str.charAt(str.length()-1) != oneAlt.charAt(i+str.length())){oneAltFlips++;}
            else if(str.charAt(str.length()-1) != zeroAlt.charAt(i+str.length())){zeroAltFlips++;}
            minFlips = Math.min(minFlips,Math.min(oneAltFlips, zeroAltFlips));
        }

        return minFlips;
    }

    private char oppositeChar(StringBuilder builder, int i) {
        return builder.charAt(i) == '1'?'0':'1';
    }

}
