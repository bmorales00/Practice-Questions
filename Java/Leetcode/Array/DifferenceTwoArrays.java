package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DifferenceTwoArrays {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        if(nums1 == null || nums2 == null){return new ArrayList<>();}
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1= new ArrayList<>();
        List<Integer> res2= new ArrayList<>();
        for(int val:nums1){
            set.add(val);
        }
        for(int val:nums2){
            set2.add(val);
        }

        for(int val:set){
            if(!set2.contains(val)){res1.add(val);}
        }
        for(int val:set2){
            if(!set.contains(val)){res2.add(val);}
        }
        res.add(res1);
        res.add(res2);
        return res;
    }
}
