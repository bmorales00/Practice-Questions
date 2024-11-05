package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    //Time Complexity: O(3^n) Exponential or O(3^4) || Space Complexity: O(3^n) or O(3^4)
    public List<String> restoreIPAddresses(String s){
        if(s.length() >12){return new ArrayList<>();}
        StringBuilder ip = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(s,ip,0,0,res);

        return res;
    }

    private void backtrack(String s, StringBuilder ip, int start,int dot,List<String> res) {
        if(dot==4 && start != s.length()){return;}
        if(dot == 4){
            res.add(ip.toString().substring(0,ip.length()-1));
        }
        for(int i = start;i<s.length(); i++){
            if((i+1)-start >3){return;}
            if(isValidIP(s.substring(start,i+1))){
                ip.append(s.substring(start,i+1));
                ip.append(".");
                backtrack(s,ip,i+1,dot+1,res);
                ip.deleteCharAt(ip.length()-1);
                ip.delete(start+dot,i+1+dot);
            }
        }
    }

    private boolean isValidIP(String substring) {
        if(substring.length()>1 && substring.charAt(0)-'0' == 0){return false;}
        return Integer.parseInt(substring) >=0 && Integer.parseInt(substring)<=255;
    }
}
