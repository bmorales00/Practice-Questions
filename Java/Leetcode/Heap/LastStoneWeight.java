package com.brianprojects.Leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones){
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones){
            maxHeap.offer(stone);
        }
        while(!maxHeap.isEmpty() || maxHeap.size() >1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(y != x){maxHeap.offer(y-x);}

        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}
