package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums){
        int n = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val:nums){
            if(!map.containsKey(val)){map.put(val, 1);continue;}
            map.put(val,map.get(val)+1);

        }

        for(int key:map.keySet()){
            if(map.get(key) > n){return key;}
        }
        return n;
    }
}
