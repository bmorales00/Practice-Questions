package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Time Complexity: O(2^t)| Space Complexity O(2^t)

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(res, new ArrayList<>(), 0,  candidates, target);
        return res;
    }

    private void backTracking(List<List<Integer>> res, ArrayList<Integer> list,int start,int[] candidates, int target) {
        if(target == 0){
            res.add(new ArrayList<>(list));
        }
        if(candidates[start] > target){
            return;
        }
        //[2,3,6,7]
        for(var i =start; i<candidates.length; i++ ){ //
            list.add(candidates[i]);
            backTracking(res, list, i, candidates, target-candidates[i]);
            list.remove(list.size()-1);
        }

    }
}
