package com.brianprojects.HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConflictInfo {
    public String conflictInfo(List<String> meetings){
        if(meetings.size() == 0){return "";}

        StringBuilder res = new StringBuilder();
        int conflicts = 0;
        int timeDiff = 0;
        String[] arr = meetings.get(0).split("\n");

        int size = Integer.parseInt(arr[0]);
        int[][] meet = new int[size][2];

        for(int i =0; i<size; i++){
            String[] temp = arr[i+1].split(",");
            meet[i][0] = Integer.parseInt(temp[0]);
            int min = (Integer.parseInt(temp[0].substring(2,4)) +
                    Integer.parseInt(temp[1])) %60;
            int hour = (((Integer.parseInt(temp[0].substring(0,2)) *60)+
                    Integer.parseInt(temp[1])+
                    Integer.parseInt(temp[0].substring(2,4)))/60)
                    %24;
            meet[i][1] = (hour*100)+min;
        }
        Arrays.sort(meet, Comparator.comparingInt(a -> a[0]));

        for(int i =1; i<meet.length; i++){
            if(!(meet[i][0] >= meet[i-1][1])){
                conflicts++;
                timeDiff += meet[i-1][1]- meet[i][0];
            }
        }
        res.append("conflict");
        res.append(",");
        res.append(conflicts);
        res.append(",");
        res.append(timeDiff);
     return conflicts == 0? "good":res.toString();
    }
}
