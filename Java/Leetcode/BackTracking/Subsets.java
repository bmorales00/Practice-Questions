package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

//Runtime Complexity : O(n*2^n) | Space Complexity: O(2^n)

public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(),nums, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {

        res.add(new ArrayList<>(list));
        for(var i = start; i<nums.length; i++){
            list.add(nums[i]);
            backTracking(res, list,nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
