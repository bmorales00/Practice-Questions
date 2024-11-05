package com.brianprojects.Leetcode.DP1D;

import java.util.HashSet;

public class PartitionEqual {
    public boolean canPartition(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        set2.add(0);
        int target = 0;
        for(var i = nums.length-1; i>=0; i--){
            target+=nums[i];
            for(var s: set2){
                set.add(nums[i]+s);
            }
            set2.addAll(set);
        }
        return target % 2 == 0 && set.contains(target / 2);
    }
}
