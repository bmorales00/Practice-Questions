package com.brianprojects.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static List<List<Integer>> find(List<List<Integer>> allLocations, int numRestaurants){

        if(allLocations == null || allLocations.size() == 0 || numRestaurants > allLocations.size()) {
            return List.of(new ArrayList<>());
        }
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Double, List<List<Integer>>> map = new HashMap<>();
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for(var i = 0; i<allLocations.size(); i++){
            int x = allLocations.get(i).get(0);
            int y = allLocations.get(i).get(1);
            int z = (x*x)+(y*y);
            double sq = Math.sqrt(z);
            if(!map.containsKey(sq)){
                map.put(sq, new ArrayList<>());
            }
            map.get(sq).add(allLocations.get(i));
        }
        priorityQueue.addAll(map.keySet());

        int count = 0;

        while(!priorityQueue.isEmpty() && res.size() != numRestaurants){
            double key = priorityQueue.poll();
            for(int i = 0 ; i< map.get(key).size();i++){
                if(res.size() == numRestaurants){
                    break;
                }
                res.add(map.get(key).get(i));
            }
        }

        return res.size() == numRestaurants? res:new ArrayList<>();
    }
    public static int min(List<List<String>> area){
        int m = area.size();
        int distance = 0;

        for(int r = 0; r<m; r++) {
            for(int c = 0; c<area.get(r).size(); c++){
                if(area.get(r).get(c) == "1"){
                    distance = dfs(area,r,c);
                }
            }
        }
        return distance;
    }

    private static int dfs(List<List<String>> area, int r, int c ) {
        if(r<0 || r>=area.size() || c<0 || c>area.get(r).size()){
            return 0;
        }
        if(area.get(r).get(c)=="0"){
            return 0;
        }

        area.get(r).get(c).replace(area.get(r).get(c),"0");
        return dfs(area, r-1, c) +dfs(area, r+1, c)+
                dfs(area, r, c-1) +  dfs(area, r, c+1) +1;
    }

}
