package com.brianprojects.Leetcode.Heap;

import java.util.PriorityQueue;

public class SeatManager {
    int[] reserved;
    PriorityQueue<Integer> minHeap;
    //Time Complexity: O(1) | Space Complexity: O(n)
    public SeatManager(int n) {
        reserved = new int[n+1];
        minHeap = new PriorityQueue<>();
        for(int i =1 ; i<=n; i++){
            minHeap.add(i);
        }
    }

    //Time Complexity: O(1)
    public int reserve(){
        if(minHeap.isEmpty()){return -1;}
        int res = minHeap.poll();
        reserved[res]++;
        return res;
    }

    //Best Case: Time Complexity: O(1)
    //Worst Case: Time Complexity: O(log n)
    public void unreserve(int seatNumber){
        if(seatNumber >= reserved.length){return;}
        if(reserved[seatNumber] == 1){
            reserved[seatNumber]--;
            minHeap.add(seatNumber);
        }
    }
}
