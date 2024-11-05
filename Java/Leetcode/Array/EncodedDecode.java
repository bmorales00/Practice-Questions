package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class EncodedDecode {
    /*
    Design an algorithm to encode a list of strings to a string. The encoded string is then sent
    over the network and is decoded back to the original list of strings.
    Please implement encode and decode
     */
    public static String encode(List<String> strs){
        StringBuilder str = new StringBuilder();
        for(var string : strs){
            str.append(string.length());
            str.append("$");
            str.append(string);
        }
        return str.toString();
    }
    public static List<String> decode(String str){
        List<String> strList = new ArrayList<>();
        int pointer = 0;
        while(pointer < str.length()){
            StringBuilder newStr = new StringBuilder();
            if(Character.isDigit(str.charAt(pointer)) && str.charAt(pointer+1) == '$'){
                int counter = str.charAt(pointer) - '0';
                pointer +=2;
                while(counter >0 ){
                    newStr.append(str.charAt(pointer++));
                    counter--;
                }
                strList.add(newStr.toString());
                newStr.delete(0, newStr.length());
            }

        }
        return strList;
    }
}
/*
public List<String> decode(String s) {
            List<String> list = new ArrayList<String>();
            StringBuffer sb = new StringBuffer(s);

            int endIndex = 0;
            while (endIndex < s.length()) {
                int index = sb.toString().indexOf('/', endIndex); // @note: first `/` after index i
                int length = Integer.parseInt(sb.substring(0, index));
                endIndex = index + length + 1;
                String str = sb.substring(index + 1, endIndex);
                list.add(str);
            }
            return list;
        }

 */
