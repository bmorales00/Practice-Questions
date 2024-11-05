package com.brianprojects.Leetcode.MathAndGeo;

public class GreatestCommonDivisor {

    //Time Complexity: O(n) || Space Complexity: O(n)
    public String gcdOfStrings(String str1, String str2){
        if(str2.charAt(0) != str1.charAt(0)){return "";}
        if(str1.length() == str2.length() && !str1.equals(str2)){return "";}
        int small = Math.min(str1.length(),str2.length());
        int l = 0;
        int r = 1;
        while(l<small){
            if(str1.length()%(l+1) == 0 && str2.length()%(l+1) == 0){
                r=l+1;
            }
            l++;
        }
        String res = str2.substring(0,r);
        for(int i = 0; i<str1.length(); i+=r){
            if(!str1.substring(i,i+r).equals(res)){
                return "";
            }
        }
        for(int i = 0; i<str2.length(); i+=r){
            if(!str2.substring(i,i+r).equals(res)){
                return "";
            }
        }

        return res;
    }
}
/*
String res = "";
        int s = str2.length();
        while(s>0){
            if(str1.length()%s != 0){s--; continue;}
            int i = 0;
            String sub = str2.substring(0, s);
            while(i+s<=str1.length() && str1.substring(i,i+s).equals(sub)){
                i+=s;
            }
            if(i==str1.length()){
                return sub;
            }
            s--;
        }

        return res;
 */