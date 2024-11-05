package com.brianprojects.HackerRank;

public class SuperReducedString {
    public static String superReducedString(String s){
        StringBuilder sb  = new StringBuilder(s);

        for(int i = 1; i<sb.length(); i++){
            if(sb.charAt(i) == sb.charAt(i-1)){
                sb.delete(i-1, i+1);
                i = 0;
            }
        }
        return sb.length() == 0? "Empty String": sb.toString();
    }
}
