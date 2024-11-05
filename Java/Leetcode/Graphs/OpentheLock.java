package com.brianprojects.Leetcode.Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class OpentheLock {
    //Time Complexity: O(10^4)|| Space Complexity: O(10^4)
    public int openLocck(String[] deadends, String target){
        if(deadends == null){return -1;}

        HashSet<String> visited = new HashSet<>();
        HashSet<String> deadendsSet = new HashSet<>();
        deadendsSet.addAll(Arrays.asList(deadends));
        if(deadendsSet.contains("0000")){return -1;}
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        int count = 0;

        while(!queue.isEmpty()){
            int size =queue.size();
            while(size>0) {
                StringBuilder polled = new StringBuilder(queue.poll());
                if (deadendsSet.contains(polled.toString())) {
                    size--;
                    continue;
                }
                if (polled.toString().equals(target)) {
                    return count;
                }
                for (int i = 0; i < polled.length(); i++) {
                    int val = Character.getNumericValue(polled.charAt(i));
                    int inc = (val + 1) % 10;
                    int dec = (10 + val - 1) % 10;
                    StringBuilder res1 = new StringBuilder(polled);
                    StringBuilder res2 = new StringBuilder(polled);
                    res1.setCharAt(i, Character.forDigit(inc, 10));
                    res2.setCharAt(i, Character.forDigit(dec, 10));
                    if (!visited.contains(res1.toString()) && !deadendsSet.contains(res1.toString())) {
                        queue.add(res1.toString());
                        visited.add(res1.toString());
                    }
                    if (!visited.contains(res2.toString())&& !deadendsSet.contains(res2.toString())) {
                        queue.add(res2.toString());
                        visited.add(res2.toString());
                    }
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}
/*
Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String s = q.poll();
                if(deads.contains(s)) {
                    size --;
                    continue;
                }
                if(s.equals(target)) return level;
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size --;
            }
            level ++;
        }
        return -1;
 */