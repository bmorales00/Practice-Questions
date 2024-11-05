package com.brianprojects.Leetcode.MathAndGeo;

public class IntegerToRoman {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public String intToRoman(int num) {
        if(num <=0){return "";}
        StringBuilder res = new StringBuilder();

        int val = num;
        while (val >0){
            if(1000 <= val){
                int times = val/1000;
                res.append("M".repeat(times));
                val%=1000;
            }
            else if(900 <= val){
                int times = val/900;
                res.append("CM".repeat(times));
                val%=900;
            }
            else if(500 <= val){
                int times = val/500;
                res.append("D".repeat(times));
                val%=500;
            }
            else if(400 <= val){
                int times = val/400;
                res.append("CD".repeat(times));
                val%=400;
            }
            else if(100 <= val){
                int times = val/100;
                res.append("C".repeat(times));
                val%=100;
            }
            else if(90 <= val){
                int times = val/90;
                res.append("XC".repeat(times));
                val%=90;
            }
            else if(50 <= val){
                int times = val/50;
                res.append("L".repeat(times));
                val%=50;
            }
            else if(40 <= val){
                int times = val/40;
                res.append("XL".repeat(times));
                val%=40;
            }
            else if(10 <= val){
                int times = val/10;
                res.append("X".repeat(times));
                val%=10;
            }
            else if(9 <= val){
                int times = val/9;
                res.append("IX".repeat(times));
                val%=9;
            }
            else if(5 <= val){
                int times = val/5;
                res.append("V".repeat(times));
                val%=5;
            }
            else if(4 <= val){
                int times = val/4;
                res.append("IV".repeat(times));
                val%=4;
            }
            else{
                int times = val;
                res.append("I".repeat(times));
                val%=1;
            }
        }
        return res.toString();
    }
}
