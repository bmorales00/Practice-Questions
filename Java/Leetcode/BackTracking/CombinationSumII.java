package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(2^t) | Space Complexity is O(2^t)

public class CombinationSumII {
    public List<List<Integer>> combinationSumII(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(res, new ArrayList<>(), candidates,target,0);
        return res;

    }
    private void backTracking(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int start) {
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(start >candidates.length-1||candidates[start] > target){
            return;
        }
        int visited = Integer.MIN_VALUE;
        for(int i = start; i<candidates.length; i++){
            if(visited != candidates[i]){
                list.add(candidates[i]);
                backTracking(res, list, candidates, target-candidates[i], i+1);
                visited = list.get(list.size()-1);
                list.remove(list.size()-1);
            }
        }
    }
}
