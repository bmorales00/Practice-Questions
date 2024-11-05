package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    //Time Complexity: O(n! *nlogn) || Space Complexity; O(n!)
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){return res;}
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited,res, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, List<List<Integer>> res, ArrayList<Integer> comb) {

        if(comb.size() == nums.length){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){continue;}
            if(i>0 && nums[i-1] == nums[i] && !visited[i-1]){continue;}
            visited[i] = true;
            comb.add(nums[i]);
            backtrack(nums,visited,res,comb);
            visited[i] =false;
            comb.remove(comb.size()-1);
        }
    }

}
