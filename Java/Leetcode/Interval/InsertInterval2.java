package com.brianprojects.Leetcode.Interval;

import java.util.Stack;

public class InsertInterval2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){return new int[][]{{newInterval[0],newInterval[1]}};}
        Stack<int[]> head = new Stack<>();
        boolean isInserted = false;

        for(int i = 0; i<intervals.length; i++){
            int start = intervals[i][0];int end = intervals[i][1];
            int newStart = newInterval[0]; int newEnd  = newInterval[1];
            if((!isInserted) && newStart<=end && newEnd>=start){
                newInterval[0] = Math.min(start, newStart);
                newInterval[1] = Math.max(end,newEnd);
            }
            else if((!isInserted) && start>=newStart){
                head.push(newInterval);
                head.push(intervals[i]);
                isInserted = true;
            }
            else{
                head.push(intervals[i]);
            }
        }
        if(!isInserted){head.push(newInterval);}
        int[][] res = new int[head.size()][2];
        for(int i  = res.length-1; i>=0;i--){
            res[i] = head.pop();
        }

        return res;
    }
}
