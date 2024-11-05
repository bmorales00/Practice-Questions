package com.brianprojects.Leetcode.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveIntervals {
    //Time Complexity: O(n log n) || Space Complexity: O(1)
    public int removeCoveredIntervals(int[][] intervals){
        if(intervals == null){return 0;}
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] low = intervals[0];
        int count = 0;
        for(int i =1; i<intervals.length; i++){
            if(intervals[i][1] <= low[1]){
                count++;
            }
            else if(low[0] == intervals[i][0] && low[i] <=intervals[i][1]){
                count++;
                low = intervals[i];
            }
            else{
                low = intervals[i];
            }
        }
        return intervals.length-count;
    }
}
