package com.brianprojects.Leetcode.Array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums){
        if(nums == null){return " ";}
        int n = nums.length;
        String[] numstr = new String[n];
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<n;i++){
            numstr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numstr, new LargerValueComparator());
        if(numstr[0].equals("0")){return "0";}
        for(String s: numstr){
            res.append(s);
        }
        return res.toString();
    }
    public static class LargerValueComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s2.compareTo(s1);
        }
    }


}
/*
StringBuilder res = new StringBuilder();
        Arrays.sort(nums);
        int l =0;
        int r = nums.length-1;
        while(l<r){
            StringBuilder word1 = new StringBuilder();StringBuilder word2 = new StringBuilder();
            word1.append(nums[l]);word1.append(nums[r]);
            word2.append(nums[r]);word2.append(nums[l]);

            if(word1.compareTo(word2) > word2.compareTo(word1)){
                word1 = new StringBuilder(res);word2=new StringBuilder(res);
                word1.append(nums[l]);
                word2.insert(0,nums[l]);
                if(!res.isEmpty() &&word2.compareTo(word1) > word1.compareTo(word2)){
                    res = new StringBuilder(word2);
                }
                else{
                    res = new StringBuilder(word1);
            }
                l++;
            }
            else{
                word1 = new StringBuilder(res);word2=new StringBuilder(res);
                word1.append(nums[r]);
                word2.insert(0,nums[r]);
                if(!res.isEmpty() && word2.compareTo(word1) > word1.compareTo(word2)){
                    res = new StringBuilder(word2);
                }
                else{
                    res = new StringBuilder(word1);
                }
                r--;
            }
        }
        if(l==r){res.append(nums[l]);}


        return res.toString();
 */

