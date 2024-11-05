package com.brianprojects.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinMax4 {
    public void printminmax(List<Integer> array){
        Collections.sort(array);
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0;i<array.size(); i++){
            if(i == array.size()-1){
                break;
            }
            sum+=array.get(i);
        }
        min = Math.min(min, sum);
        max = Math.max(max, sum);
        sum-=array.get(0);
        sum+=array.get(array.size()-1);
        min = Math.min(min, sum);
        max = Math.max(max, sum);

        System.out.println(min + " " + max);
    }
}
