package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDissappeared {
    public List<Integer> findDissappearedNumbers(int[] nums){
        if(nums.length <= 0 || nums == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        var n = nums.length;
        int[] arr = new int[n+1];
        Arrays.fill(arr, n);
        for(var i = 0; i<n; i++){
            arr[nums[i]]--;
        }
        for(var i = 1; i<arr.length;i++){
            if(arr[i] == n){
                res.add(i);
            }
        }
       return res;
    }
 }
