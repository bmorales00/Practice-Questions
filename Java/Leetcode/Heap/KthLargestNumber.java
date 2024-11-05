package com.brianprojects.Leetcode.Heap;

import java.util.PriorityQueue;

public class KthLargestNumber {
    //Time Complexity: O((n+k)*logk) || Space Complexity: O(k)
    public String kthLargestNumber(String[] nums, int k){
        if(nums == null || k>nums.length){return "";}
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1,s2) ->{
            if(s1.length() == s2.length()){
                return s1.compareTo(s2);
            }
            return Integer.compare(s1.length(),s2.length());
        });

        for(String n: nums){
            maxHeap.offer(n);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }


}
