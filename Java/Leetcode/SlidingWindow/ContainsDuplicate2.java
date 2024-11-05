package com.brianprojects.Leetcode.SlidingWindow;

import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums == null){return false;}
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else{
                if(Math.abs(map.get(nums[i]) - i) <=k){return true;}
                map.replace(nums[i],map.get(nums[i]), i);
            }
        }
        return false;
    }
}
