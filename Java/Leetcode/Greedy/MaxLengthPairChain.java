package com.brianprojects.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain {

    //Time Complexity: O(nlogn) || Space Complexity: O(1)
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count = 0, end = Integer.MIN_VALUE;
        for(int[] cur : pairs){
            if(end < cur[0]){
                end = cur[1];
            }
            else{count++;}
        }
        return pairs.length-count;
    }
}
