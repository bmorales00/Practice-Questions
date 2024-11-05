package com.brianprojects.Leetcode.BackTracking;

import java.util.HashSet;

public class FindUniqueBinaryString {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public String findDifferentBinaryString(String[] nums){
        StringBuilder res = new StringBuilder();
        char ch;

        for(int  i = 0; i<nums.length; i++){
            ch = nums[i].charAt(i);
            res.append(ch == '0'?'1':'0');
        }
        return res.toString();
    }

    public String findDifferentBinaryString2(String[] nums){
        if(nums == null){return "";}
        int strLength = nums[0].length();
        StringBuilder res = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<strLength; i++){
            res.append("1");
            set.add(nums[i]);
        }

        return backtrack(res, set, 0)?res.toString():"";
    }

    private boolean backtrack(StringBuilder res, HashSet<String> set,  int index) {
        if(!set.contains(res.toString())){return true;}
        for(int i = index; i<res.length();i++){
            var temp = res.charAt(i);
            res.setCharAt(i, temp == '1'?'0':'1');
            if(backtrack(res,set,index+1)){return true;}
            res.setCharAt(i, temp);
        }
        return false;
    }
}
