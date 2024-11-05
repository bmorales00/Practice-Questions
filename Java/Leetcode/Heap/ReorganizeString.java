package com.brianprojects.Leetcode.Heap;

import java.util.*;

public class ReorganizeString {
    //Time Complexity: O(s log n) || Space Complexity: O(s)
    public String reorganizeString(String s){
        if(s.length() == 0){
            return s;
        }
        StringBuilder res = new StringBuilder(s.length());
        Map<Character, Integer> map = new HashMap<>();
        for(var ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> (b.getValue() -a.getValue()));
        maxHeap.addAll(map.entrySet());
        Map.Entry<Character, Integer> ch = null;
        while(!maxHeap.isEmpty()){
            res.append(maxHeap.peek().getKey());
            maxHeap.peek().setValue(maxHeap.peek().getValue()-1);
            if(ch !=null && ch.getValue() > 0){
                Map.Entry<Character, Integer> temp = maxHeap.poll();
                maxHeap.add(ch);
                ch = temp;
            }
            else{
                ch = maxHeap.poll();

            }
        }
        if(ch.getValue() == 0){ch = null;}
        if(ch!= null && (ch.getValue()>1 && ch.getKey() == res.charAt(res.length()-1))){
            return "";
        }
        return res.toString();
    }
}
