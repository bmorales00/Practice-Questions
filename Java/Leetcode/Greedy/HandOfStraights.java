package com.brianprojects.Leetcode.Greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HandOfStraights {
    //Time Complexity: O(n log n) || Space Complexity: O(n)
    public boolean isNStraightHand(int[] hand, int groupSize){
        if(hand.length%groupSize != 0){return false;}

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val:hand){
            if(!map.containsKey(val)){minHeap.offer(val);}
            map.put(val, map.getOrDefault(val,0)+1);
        }
        while(!minHeap.isEmpty()){
            int val = minHeap.peek();
            for(int i =0; i<groupSize; i++){
                if(!map.containsKey(val)||map.get(val) == 0 ){return false;}
                map.replace(val, map.get(val), map.get(val)-1);
                if(map.get(val) ==0){minHeap.poll();}
                val+=1;
            }
        }
        return true;
    }
}
