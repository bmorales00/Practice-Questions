package com.brianprojects.Leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Time Complexity : O(p log p ) for the points to add to the min heap | Space Complexity is O(p) + O(k)
public class KClosest {

    public int[][] kClosest(int[][] points, int k){
        if( k > points.length){
            return new int[0][];
        }
        int[][] res = new int[k][2];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

        for(int start = 0; start< points.length; start++){
            int x = points[start][0];
            int y = points[start][1];
            int distance = (x*x) + (y*y);
            minHeap.add(new int[]{distance, start});

        }
        int index = 0;
        while(!minHeap.isEmpty() && index < res.length){
            res[index][0] = points[minHeap.peek()[1]][0];
            res[index][1] = points[minHeap.peek()[1]][1];
            minHeap.poll();
            index++;
        }

        return res;
    }
}
