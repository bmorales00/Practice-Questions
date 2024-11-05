package com.brianprojects.Leetcode.DP1D;

import java.util.Arrays;
import java.util.HashMap;
// Time Complexity: O(n) * O(n*log n)  | Space Complexity: O(n)

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums){
        if(nums == null|| nums.length <=0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(var n: nums){
            if(!map.containsKey(n)){
                map.put(n,0);
            }
            map.replace(n, map.get(n), map.get(n)+1);
        }
        int mapSize = map.keySet().size();
        int[] dp = new int[mapSize];
        int index = map.get(nums[0]);
        int key = nums[0];
        dp[0] = key*index;
        if(!(mapSize >=2)){
            return dp[0];
        }
        dp[1] = nums[index]-1 == key?nums[index]*map.get(nums[index]):nums[index]*map.get(nums[index])+dp[0];
        key=nums[index];
        index += map.get(key);

        for(var i = 2; i<dp.length; i++){
            if(index<nums.length){
                dp[i] = nums[index] * map.get(nums[index]);
                if(nums[index] -1 != key){
                    dp[i] += Math.max(dp[i-1], dp[i-2]);
                }
                else{
                    dp[i] += i-3<0? dp[i-2]: Math.max(dp[i-2], dp[i-3]);
                }
                key = nums[index];
                index+=map.get(nums[index]);
            }
        }

        return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }
}

/*
int max = 0;
        for(var x =0; x<nums.length; x++){
//            if(set.contains(x)){
//                continue;
//            }
            HashSet<Integer> set = new HashSet<>();
            set.add(x);
            int num = nums[x];
            int total = 0;
            for(var y = 0; y<nums.length; y++){
                if(nums[y] == num+1 || nums[y] == num-1 && !set.contains(y)){
                    set.add(y);
                }
                else{
                    total+= nums[y];
                }
            }
            max = Math.max(max, total);

        }
        return max;
 */