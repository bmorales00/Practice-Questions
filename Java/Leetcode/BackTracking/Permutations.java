package com.brianprojects.Leetcode.BackTracking;

import java.util.*;
//Time Complexity: O(n (n!)) | Space Complexity O(n!)

public class Permutations {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res,new ArrayList<>() ,new HashSet<>() ,nums, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res,List<Integer> list,HashSet<Integer> set,int[] nums, int start) {
        if(nums.length == 1){
            list.add(nums[0]);
            res.add(list);
            return;
        }
        if(set.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                list.add(nums[i]);
                backTracking(res, list,set, nums, start);
                set.remove(nums[i]);
                list.remove(list.size()-1);
            }
        }
    }
}
/*
   List<List<Integer>> res = new ArrayList<>();
       palind(res,nums,0);
       return res;
    }

    void palind(List<List<Integer>> resi,int[] nums,int start){
        if(nums.length==start){
            resi.add(toList(nums));
        }
        else{
        for(int i =start;i<nums.length;i++){
            swap(i,start,nums);
            palind(resi,nums,start+1);
            swap(i,start,nums);
         }
        }
    }

    public List<Integer> toList(int[] nums){
         List<Integer> result = new ArrayList<>();
        for(int i : nums)
            result.add(i);

        return result;
    }
    public void swap(int i,int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
 */