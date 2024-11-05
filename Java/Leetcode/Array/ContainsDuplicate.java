package com.brianprojects.Leetcode.Array;

import java.util.HashSet;

public class ContainsDuplicate {
    /*
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
     */

    //Runtime is O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();

        for(var n: nums){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
