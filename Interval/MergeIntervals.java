package com.brianprojects.LeetQues75.Interval;

import java.util.Arrays;

public class MergeIntervals {
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */
    public static int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return null;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[][] mergedIntervals = new int[intervals.length][];
        var pointer = 0;
        var count = 0;

        for(var i = 1; i<intervals.length; i++){
            if(intervals[i][0] <= intervals[pointer][1] && intervals[i][0] >= intervals[pointer][0]){
                intervals[pointer][0] = Math.min(intervals[i][0], intervals[pointer][0]);
                intervals[pointer][1]= Math.max(intervals[i][1], intervals[pointer][1]);
            }
            else{
                mergedIntervals[count++] = intervals[pointer];
                pointer = i;
            }
        }
        mergedIntervals[count++] = intervals[pointer];
        mergedIntervals = Arrays.copyOf(mergedIntervals, count);


        return mergedIntervals;

    }
}
