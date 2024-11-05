package com.brianprojects.Leetcode.BinarySearch;

public class ShipPackages {
    //Time Complexity: O(n*log m) || Space Complexity: O(1)
    public int shipWithinDays(int[] weight, int days){
        if(weight == null){return -1;}
        int upperBound = 0;
        int lowerBound = 0;
        int minShipped = Integer.MAX_VALUE;
        for(int w:weight){
            upperBound+=w;
            lowerBound = Math.max(lowerBound, w);
        }
        while(lowerBound <= upperBound){
            int midBound = (lowerBound+upperBound)/2;
            int sum = 0;
            int day =1;
            int i = 0;
            while(i<weight.length && day <= days){
                if (sum + weight[i] <= midBound) {
                    sum += weight[i];
                } else if (sum + weight[i] > midBound) {
                    sum = weight[i];
                    day++;
                }
                i++;
            }
            if(day <= days && i == weight.length){minShipped = Math.min(minShipped, midBound); upperBound = midBound-1;}
            else {lowerBound = midBound+1;}
        }
        return minShipped;
    }

//    private boolean canBeShipped(int[] weight, int days, int midBound) {
//        int sum = 0;
//        int day =1;
//        int i = 0;
//        while(i<weight.length && day != days){
//            if (sum + weight[i] <= midBound) {
//                sum += weight[i];
//            } else if (sum + weight[i] > midBound) {
//                sum = weight[i];
//                day++;
//            }
//            i++;
//        }
//        return day == days && i == weight.length;
//    }
}
/*
if(canBeShipped(weight, days, midBound)){
                minShipped = Math.min(minShipped, midBound);
                lowerBound = midBound+1;
            }
            else{
                upperBound = midBound-1;
            }
 */