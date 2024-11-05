package com.brianprojects.Leetcode.Interval;
//WORK ON THISSSSS IMPLEMENTATION

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    /*
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
    represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
    still does not have any overlapping intervals (merge overlapping intervals if necessary).
    Return intervals after the insertion.
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null){
            return null;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> insertedIntervals = new ArrayList<>();
        Boolean hasBeenInserted = false;
        var pointer = 0;
        //var indexList = 0;
        var start = 0;
        var end = 1;

        if(intervals.length == 0){
            insertedIntervals.add(newInterval);
            return insertedIntervals.toArray(new int[0][]);
        }

        while(pointer < intervals.length){
            // if overlaps
            if(newInterval[start] <= intervals[pointer][end] && newInterval[end] >= intervals[pointer][start]
                    && !hasBeenInserted){
                newInterval[start] = Math.min(newInterval[start],intervals[pointer][start]);
                newInterval[end] = Math.max(newInterval[end], intervals[pointer][end]);
            }

            else if(intervals[pointer][start] >= newInterval[start] && !hasBeenInserted){
                //insertedIntervals.add(indexList, newInterval);
                insertedIntervals.add(newInterval);
                insertedIntervals.add(intervals[pointer]);
                hasBeenInserted = true;
            }
            else{
                insertedIntervals.add(intervals[pointer]);
                //indexList++;

            }
            pointer++;
        }
        if(!hasBeenInserted){
            insertedIntervals.add(newInterval);
        }


        return insertedIntervals.toArray(new int[0][]);
    }
}

