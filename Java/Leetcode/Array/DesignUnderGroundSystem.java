package com.brianprojects.Leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DesignUnderGroundSystem {
    private final int[] checkedInTime;
    private final HashMap<Integer, String> checkedIn;
    private final HashMap<String, List<Integer>> averageTime;

    public DesignUnderGroundSystem() {
        this.checkedInTime = new int[1000000];
        this.checkedIn = new HashMap<>();
        this.averageTime = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t){
        if(this.checkedIn.containsKey(id) && checkedInTime[id] != 0){return;}
        this.checkedIn.put(id, stationName);
        checkedInTime[id] = t;
    }
    public void checkOut(int id, String stationName, int t){
        if(this.checkedInTime[id]  == 0){return;}
        int checkIn = this.checkedInTime[id];
        String start = this.checkedIn.get(id).toLowerCase();
        String avgStations = start +"_"+stationName.toLowerCase();
        if(!this.averageTime.containsKey(avgStations)){averageTime.put(avgStations,new ArrayList<>());}
        this.averageTime.get(avgStations).add(t-checkIn);
        this.checkedInTime[id] = 0;
        this.checkedIn.remove(id);
    }
    public double getAverageTime(String startStation, String endStation){
        String avgStations = startStation.toLowerCase()+"_"+endStation.toLowerCase();
        int size = 0;
        int total = 0;
        for(int t:this.averageTime.get(avgStations)){
            total+=t;
            size+=1;
        }
        return (double)total/size;
    }
}
