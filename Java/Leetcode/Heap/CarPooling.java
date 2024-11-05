package com.brianprojects.Leetcode.Heap;

import java.util.*;

public class CarPooling {
    //Time Complexity: O(t log minheap) + O(minheap log queue) || Space Complexity: O(t)
    public boolean carPooling(int[][] trips, int capacity) {
        if(capacity == 0 || trips == null){return false;}

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.addAll(Arrays.asList(trips));

        int currCapacity = 0;

        while(!minHeap.isEmpty()){
            while(!queue.isEmpty() && queue.peek()[1] <= minHeap.peek()[1]){
                currCapacity-=queue.poll()[0];
            }
            currCapacity+=minHeap.peek()[0];
            if(currCapacity > capacity){
                return false;
            }
            queue.add(new int[]{minHeap.peek()[0],minHeap.peek()[2]});
            minHeap.poll();
        }
        return true;
    }
}
