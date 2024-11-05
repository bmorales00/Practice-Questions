package com.brianprojects.Leetcode.Array;

import java.util.HashSet;

public class IntersectionArrays {
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int val : nums1){
            set.add(val);
        }
        for(int val: nums2){
            if(!res.isEmpty() && res.contains(val)){
                continue;
            }
            if(set.contains(val)){
                res.add(val);
            }
        }
        int[] arr = new int[res.size()];
        int count = 0;

        for(int val : res){
            arr[count++] = val;
        }
        return arr;
    }
}
