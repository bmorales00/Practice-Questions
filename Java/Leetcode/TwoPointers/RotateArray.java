package com.brianprojects.Leetcode.TwoPointers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RotateArray {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public void rotate(int[] nums, int k){
        int startIndex = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(var num: nums){
            queue.add(num);
        }
        while(!queue.isEmpty()){
            nums[(startIndex+k) % nums.length] = queue.remove();
            startIndex++;
        }
    }
    public void rotate2(int[] nums, int k){
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        for(var i = 0; i<nums2.length;i++){
            nums[(i+k)% nums.length] = nums2[i];
        }

    }
}
