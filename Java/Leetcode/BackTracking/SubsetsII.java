package com.brianprojects.Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIme Complexity is: O(n * 2^n) | Space Complexity is : O(n *2^n)
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(res, new ArrayList<>(), nums, 0);
        return res;
    }
    //[1,2,2]
    private void backTracking(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list)); // [] -> [1]->[1,2] -> [1,2,2]
        int visited = Integer.MIN_VALUE;
        for(int i = start; i<nums.length; i++){ // i=0, i=1 // i=2
            if(nums[i] != visited) {
                list.add(nums[i]); //[1] -> [1,2] -> [1,2,2]
                backTracking(res, list, nums, i + 1);
                visited = list.get(list.size() - 1);
                list.remove(list.size() - 1); // [1]
            }
        }
    }

}
