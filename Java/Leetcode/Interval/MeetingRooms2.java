package com.brianprojects.Leetcode.Interval;

import java.util.Arrays;
import java.util.List;

public class MeetingRooms2 {
    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    find the minimum number of conference rooms required.)
     */

    public static int minMeetingRoom(List<Interval> intervals){
        if(intervals.size() ==0){
            return 0;
        }
        int roomCount = 0;
        int maxRoomCount = 0;

        int startPointer = 0;
        int endPointer = 0;

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for(var i = 0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        while(startPointer<intervals.size()){
            if(start[startPointer] < end[endPointer]){
                startPointer++;
                roomCount++;
            }
            else{
                endPointer++;
                roomCount--;
            }
            maxRoomCount = Math.max(maxRoomCount, roomCount);
        }

        return maxRoomCount;
    }
}
