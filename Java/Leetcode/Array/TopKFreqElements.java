package com.brianprojects.Leetcode.Array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElements {
    /*
    Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] mostFreq = new List[nums.length+1];
        Arrays.setAll(mostFreq, element -> new ArrayList<>());
        int[] freqElements = new int[k];
        int counter = 0;
        for(var n : nums){
            if(!map.containsKey(n)){
                map.put(n, 1);
            }
            else{
                map.replace(n, map.get(n), map.get(n)+1);
            }
        }
        for( var key: map.keySet()){
            mostFreq[map.get(key)].add(key);
        }
        for(var i = mostFreq.length-1; i>=0; i-- ){
            int start = 0;
            while(counter != k && !(start > mostFreq[i].size()-1) && !mostFreq[i].isEmpty()){
                freqElements[counter++] = mostFreq[i].get(start++);
            }
        }
        return freqElements;
    }
}
