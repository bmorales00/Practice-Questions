package com.brianprojects.Leetcode.Greedy;


import java.util.PriorityQueue;

public class EliminateMonsters {
    //Time Complexity: O()
    public int eliminateMaximum(int[] dist, int[] speed){
        if(dist == null || speed ==null){return -1;}
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<dist.length; i++){
            int val = dist[i]%speed[i] !=0?(dist[i]/speed[i])+1:(dist[i]/speed[i]);
            minHeap.add(val);
        }
        int time = 0;
        while(!minHeap.isEmpty()){
            if(time >= minHeap.peek()){
                return dist.length-minHeap.size();
            }
            minHeap.poll();
            time++;
        }

        return dist.length;
    }
}
