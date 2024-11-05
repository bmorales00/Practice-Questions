package com.brianprojects.Leetcode.Array;

import java.util.HashMap;

public class SubarraySum {
    //Time Complexity: O(n) || Space Complexity: O(n)
    public int subArraySum(int[] nums, int k){
        if(nums == null){return 0;}
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int total = 0;
        int subs = 0;
        for (int num : nums) {
            total += num;
            if (prefix.containsKey(total - k)) {
                subs += prefix.get(total - k);
            }
            if (!prefix.containsKey(total)) {
                prefix.put(total, 1);
            } else {
                prefix.replace(total, prefix.get(total), prefix.get(total) + 1);
            }
        }
        return subs;
    }
}

