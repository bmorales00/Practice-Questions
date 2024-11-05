package com.brianprojects.Leetcode.Heap;



public class TaskScheduler {
    public int leastInterval(char[] tasks, int n){
        int[] count = new int[26];
        for(char task:tasks){
            count[task-'A']++;
        }

        int max = 0;
        int cnt = 0;
        for(int i=0;i<count.length;i++){
            max = Math.max(max, count[i]);
        }
        for(int i = 0; i<count.length; i++){
            if(count[i] == max){cnt++;}
        }

        return Math.max(tasks.length, (max-1) *(n+1)+cnt);
    }
}
/*
Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> queue = new ArrayDeque<>();
        int[] charCount = new int[26];

        int time = 0;
        for(var ch : tasks){
            charCount[ch-'A'] +=1;
        }
        for(var count: charCount){
            if(count != 0){
                maxHeap.offer(count);
            }
        }

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            if(maxHeap.isEmpty()){
                time = queue.peek()[0] == 0? time: queue.peek()[1];
            }
            if((!queue.isEmpty() && queue.peek()[1] == time)){
                maxHeap.offer(queue.poll()[0]);
            }
            var next = maxHeap.poll();
            next-=1;
            ++time;
            if(next !=0){
                queue.add(new int[]{next, time+n});
            }

        }
        return time;
 */