package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length <= 1){return 0;}
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int start = 0;
        int curr = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                start--;
            }
            else{
                start++;
            }
            if(!map.containsKey(start)){
                map.put(start, i);
            }
            else{
                curr = Math.max(curr, i - map.get(start));
            }
        }
        return curr;
    }
}
