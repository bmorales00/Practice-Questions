package com.brianprojects.Leetcode.Interval;

import java.util.Arrays;

public class NOIntervals {
    /*
    Non-Overlapping Intervals:
    Given an array of intervals intervals where intervals[i] = [starti, endi],
    return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     */
    //Time Complexity: O(n log n) || Space Complexity: O(1)

    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        for(int[] cur : intervals){
            if(end <= cur[0]){
                end = cur[1];
            }else{
                ++count;
            }
        }
        return count;

    }
}
//newInterval[start] <= intervals[pointer][end] && newInterval[end] >= intervals[pointer][start]