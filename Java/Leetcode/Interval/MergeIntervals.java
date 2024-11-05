package com.brianprojects.Leetcode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    //Time Complexity: O(n log n) || Space Complexity: O(mergedIntervals)
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */
    public static int[][] merge(int[][] intervals){
        if(intervals.length == 0){return null;}
        if(intervals.length <2){return intervals;}

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        var pointer = 1;
        var start = 0;
        while(pointer < intervals.length){
            if(intervals[start][1] >= intervals[pointer][0] && intervals[start][0] <= intervals[pointer][1]){
                intervals[pointer][0] = Math.min(intervals[start][0],intervals[pointer][0]);
                intervals[pointer][1] = Math.max(intervals[start][1],intervals[pointer][1]);
                start = pointer;
            }
            else{
                mergedIntervals.add(intervals[start++]);
            }
            pointer++;

        }
        mergedIntervals.add(intervals[start]);
        return mergedIntervals.toArray(new int[0][]);
    }
}
