package com.brianprojects.Leetcode.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrayForm {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public List<Integer> addToArrayForm(int[] nums, int k){
        if(nums == null){return new ArrayList<>();}
        List<Integer> res = new ArrayList<>();
        int i = nums.length-1;
        int rem = 0;
        while(i>=0){
            int val = nums[i--];
            if(k>0){
                val += k%10;
                k/=10;
            }
            res.add((val+rem)%10);
            rem = (val+rem)/10;
        }
        k+=rem;
        while(k>0){
            res.add(k%10);
            k/=10;
        }
        Collections.reverse(res);
        return res;
    }
}
