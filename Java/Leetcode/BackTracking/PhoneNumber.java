package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity: O(n * 4^n) | Space Complexity: O(4^n)
public class PhoneNumber {
    HashMap<Character, List<Character>> phoneNumber;
    public List<String> letterCombinations(String digits) {
        if(digits.length() <=0){
            return new ArrayList<>();
        }
        createPhoneMap();
        List<String> res = new ArrayList<>();
        StringBuilder str  = new StringBuilder();
        getCombinations(digits,str, 0, res);
        return res;
    }

    private void getCombinations(String digits, StringBuilder str, int index, List<String> res) {
        if(index >= digits.length()){
            res.add(str.toString());
            return;
        }
        var list = phoneNumber.get(digits.charAt(index));

        for(int i = 0; i<list.size(); i++){
            str.append(list.get(i));
            getCombinations(digits, str, index+1,res);
            str.deleteCharAt(str.length()-1);
        }

    }

    private void createPhoneMap() {
        phoneNumber = new HashMap<>();
        phoneNumber.put('2', List.of('a','b','c'));
        phoneNumber.put('3', List.of('d','e','f'));
        phoneNumber.put('4', List.of('g','h','i'));
        phoneNumber.put('5', List.of('j','k','l'));
        phoneNumber.put('6', List.of('m','n','o'));
        phoneNumber.put('7', List.of('p','q','r','s'));
        phoneNumber.put('8', List.of('t','u','v'));
        phoneNumber.put('9', List.of('w','x','y','z'));
    }
}
