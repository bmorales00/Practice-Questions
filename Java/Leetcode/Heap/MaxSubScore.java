package com.brianprojects.Leetcode.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSubScore {

    public long maxScore(int[] nums1, int[] nums2, int k){
        if(k>nums1.length){return 0;}
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for(int i = 0; i<n;i++){pairs[i] = new int[]{nums1[i],  nums2[i]};}

        Arrays.sort(pairs, (a,b)-> b[1] - a[1]);
        PriorityQueue<Integer> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        long max =Integer.MIN_VALUE;
        long total = 0;

        for (int[] pair : pairs) {
            minheap.offer(pair[0]);
            total += pair[0];
            if(minheap.size() > k) {total -= minheap.poll();}
            if(minheap.size() == k){max = Math.max(max, total * pair[1]);}
        }

        return max;
    }


}
