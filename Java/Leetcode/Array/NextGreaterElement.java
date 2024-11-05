package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class NextGreaterElement {
    // Time Complexity : O(nums2.length) || Space Complexity: O(nums2.length)
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        if(nums1 == null || nums2 == null || nums1.length > nums2.length){
            return new int[0];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums2[nums2.length-1], -1);
        int[] res = new int[nums1.length];

        for(var i=0; i<nums2.length-1; i++){
            map.put(nums2[i], -1);
            for(var x = i+1; x<=nums2.length-1; x++){
                if(nums2[x] > nums2[i]){
                    map.replace(nums2[i], map.get(nums2[i]), nums2[x]);
                    break;
                }
            }
        }

        for(var i = 0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;

    }
}
