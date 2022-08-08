package com.brianprojects.LeetQues75.Interval;

import java.util.Arrays;

public class NOIntervals {
    /*
    Non-Overlapping Intervals:
    Given an array of intervals intervals where intervals[i] = [starti, endi],
    return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     */

    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        var slow = 0;
        var fast = 1;
        var start = 0;
        var end = 1;

        var noIntervalCount = 0;

        while(fast<intervals.length){
            if(intervals[slow][start] == intervals[fast][start] || (intervals[fast][start] < intervals[slow][end]
            && intervals[fast][start] >= intervals[slow][start])){
                noIntervalCount++;
                if(intervals[fast][end] < intervals[slow][end]){
                    slow = fast;
                }
            }
            else{
                slow = fast;
            }
            fast++;
        }
        return noIntervalCount;

    }
}
//newInterval[start] <= intervals[pointer][end] && newInterval[end] >= intervals[pointer][start]