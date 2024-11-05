package com.brianprojects.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class CartesianPlane {
    public static List<String> cartesianPlanes(List<String> circlePairs){
        List<String>result = new ArrayList<>();
        for(int i =0; i<circlePairs.size(); i++)
        {
            String[] pair = circlePairs.get(i).split(" ");
            int x1 = Integer.parseInt(pair[0]);
            int y1 = Integer.parseInt(pair[1]);
            int r1 = Integer.parseInt(pair[2]);
            int x2 = Integer.parseInt(pair[3]);
            int y2 = Integer.parseInt(pair[4]);
            int r2 = Integer.parseInt(pair[5]);

            double distanceX = Math.sqrt(Math.pow(x2-x1, 2));
            double distanceY = Math.sqrt(Math.pow(y2-y1, 2));
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                result.add("Concentric");
            }
            else if(r1-x1 == r2-x2 && r1-y1 == r2-y2) {
                result.add("Touching");
            }
            else if(distanceX + distanceY == r1 + r2) {
                result.add("Intersecting");
            }
            else if(distanceX + distanceY < r1 + r2) {
                result.add("Disjoint-Inside");
            }
            else if(distanceX + distanceY > r1 + r2) {
                result.add("Disjoint-Outside");
            }
            else {
                result.add("Error");
            }

        }
        return result;
    }
}
