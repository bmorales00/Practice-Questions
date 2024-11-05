package com.brianprojects.Leetcode.Heap;

import java.util.*;

public class KthLStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLStream(int k , int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int n:nums){
            minHeap.offer(n);
        }
    }
    public int add(int val){
        this.minHeap.add(val);
        PriorityQueue<Integer> copy = this.minHeap;
        while(copy.size() != this.k){
            copy.poll();
        }
        return copy.peek();
    }
}
