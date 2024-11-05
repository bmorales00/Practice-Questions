package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class ContinSubSum {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public boolean checkSubarraySum(int[] nums, int k ){
        if(nums.length <2){return false;}
        int n = nums.length;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,-1);
        int t = 0;
        for(int i =0; i<n;i++){
            t+=nums[i];
            if(!prefixMap.containsKey(t%k)){prefixMap.put(t%k, i);}
            else{if(i - prefixMap.get(t%k) >=2){return true;}}
        }
        return false;
    }
}
