package com.brianprojects.Leetcode.MathAndGeo;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectSquares {

    ArrayList<int[]> points;
    HashMap<String, Integer> distances;
    public DetectSquares() {
        points = new ArrayList<>();
        distances = new HashMap<>();
    }
    //Time Complexity: O(1): Space Complexity: O(n)
    public void add(int[] point){
        if(point.length >2 || point.length == 0){return;}
        String str = point[0] + "_" + point[1];
        if(!distances.containsKey(str)){
            distances.put(str, 1);
            points.add(point);
            return;
        }
        distances.replace(str, distances.get(str), distances.get(str)+1);
    }

    //Time Complexity: O(n) || Space Complexity: O(1)
    public int count(int[] point){
        if(point.length >2 || point.length == 0 || points.size()<3){return 0;}
        int finalcount = 0;
        for (int[] diagonal : this.points) {
            if (diagonal[0] == point[0] || diagonal[1] == point[1] || Math.abs(point[0] - diagonal[0]) != Math.abs(point[1] - diagonal[1])) {
                continue;
            }
            String diag = diagonal[0] + "_" +diagonal[1];
            String qx_y = point[0]+"_"+diagonal[1];
            String x_qy = diagonal[0] + "_"+point[1];
            if (this.distances.containsKey(qx_y) && this.distances.containsKey(x_qy)) {
                int count = distances.get(diag);
                count *= this.distances.get(qx_y) * this.distances.get(x_qy);
                finalcount += count;
            }
        }
        return finalcount;
    }
}
//(Math.abs(px - x) != Math.abs(py - y)