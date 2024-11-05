package com.brianprojects.Leetcode.BitManipulation;

public class AddBinary {
    public String addBinary(String a, String b){
        if(a.length() < b.length()){
            var temp = a;
            a = b;
            b = temp;
        }
        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j  = b.length()-1;
        boolean rem = false;
        while(i>=0 && j>=0){
            char x = a.charAt(i);
            char y = b.charAt(j);
            if(x== '0' &&  y == '0'){
                if(rem){
                    res.append('1');
                    rem = false;
                }
                else{
                    res.append('0');
                }
            }
            else if(x == '0' && y == '1'){
                if(rem){
                    res.append('0');
                }
                else{
                    res.append('1');
                }
            }
            else if(x == '1' && y == '0'){
                if(rem){
                    res.append('0');
                }
                else{
                    res.append('1');
                }
            }
            else if(x == '1' &&  y == '1'){
                if(rem){
                    res.append('1');
                }
                else{
                    res.append('0'); rem = true;
                }
            }
            i--;j--;
        }
        while(i>=0){
            char x = a.charAt(i);
            if(x == '0'){
                if(rem){
                    res.append('1');
                    rem = false;
                }
                else{
                    res.append('0');
                }
            }
            if(x == '1'){
                if(rem){
                    res.append('0');
                }
                else{
                    res.append('1');
                }
            }
            i--;
        }
        if(rem){res.append('1');}
        while(res.length() >1 && res.charAt(res.length()-1) == '0'){
            res.deleteCharAt(res.length()-1);
        }
        res.reverse();
        return res.toString();
    }
}
