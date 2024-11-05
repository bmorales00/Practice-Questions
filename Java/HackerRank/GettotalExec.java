package com.brianprojects.HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GettotalExec {
    public static List<Integer> getTotalExecutionTime(int n, List<String> logs){
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<logs.size(); i++){
            String[] log = logs.get(i).split(":");
            String id = log[0];
            String status = log[1];
            int time = Integer.parseInt(log[2]);
            if(status.equals("start")){
                map.put(id, time);
            }
            else{
                int start = map.get(id);
                int total = time - start;
                result.add(total);
            }
        }
        return result;
    }
}
