package com.brianprojects.Leetcode.Interval;

import java.util.*;

public class MeetingRooms {
    /*
    Given an array of meeting time intervals consisting of start and
    end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     */

    public static boolean canAttendMeetings(List<Interval> intervals){
        if(intervals.size() ==0){
            return false;
        }
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        for(var i = 0; i < intervals.size()-1; i++){
            if(!(intervals.get(i).end <= intervals.get(i+1).start)){
                return false;
            }
        }
        return true;

//        int minStart = intervals.get(0).start;
//        int maxEnd = intervals.get(0).end;
//
//        for(var i = 1; i<intervals.size(); i++){
//            if(!(intervals.get(i).start >= maxEnd || intervals.get(i).end <= minStart)){
//                return false;
//            }
//            minStart = Math.min(minStart, intervals.get(i).start);
//            maxEnd = Math.max(maxEnd, intervals.get(i).end);
//        }
//
//        return true;
    }
}
